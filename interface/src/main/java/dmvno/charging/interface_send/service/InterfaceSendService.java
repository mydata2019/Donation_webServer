package dmvno.charging.interface_send.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dmvno.charging.interface_send.client.SendAttemptClient;
import dmvno.charging.interface_send.client.dto.HistoryAttempt;
import dmvno.charging.interface_send.client.dto.SendAttempt;
import dmvno.charging.interface_send.domain.AuthBeans;
import dmvno.charging.interface_send.domain.HistoryBeans;
import dmvno.charging.interface_send.domain.NeBeans;
import dmvno.charging.interface_send.event.EventDispatcher;
import dmvno.charging.interface_send.mapper.SendRepository;

@Service
public class InterfaceSendService {

	private SendAttemptClient sendAttempClient;
	@Autowired
	private SendRepository sendRepo; //repository
	
	InterfaceSendService(SendAttemptClient attemptClient) {
		this.sendAttempClient = attemptClient;
		}

	
	// 권한 확인 (업무코드 : A1)
	public String checkAuth(final AuthBeans authBeans) {
		
		System.out.println("IF 처리 시작");
		System.out.println("auth 호출 >>>>>>");
		
		/* NE_IF insert */
		int req_num = sendRepo.getReqNum();
		NeBeans neBeans = new NeBeans();
		neBeans.setNe_if_cl_cd("OTH");
		neBeans.setChg_cd("A1");
		neBeans.setReq_ser_num(req_num);
		neBeans.setUser_id(authBeans.getUser_id());
		neBeans.setOrg_id(authBeans.getOrg_id());
		neBeans.setOp_ctt(authBeans.getId() + "/" + authBeans.getPw());
		sendRepo.insertIF(neBeans);
		
		/* 기부업체 - 인증  */
		// 업체별 URL 확인
		String url = sendRepo.getURL(authBeans.getOrg_id());
		// 기부업체 LOGIN
		SendAttempt sendAttempt = sendAttempClient.callAuth(url, authBeans.getId(), authBeans.getPw());
		
		System.out.println("auth 로부터의 응답 : " + sendAttempt.getLinkYn());
		
		if(sendAttempt.getLinkYn().equals("Y")) {
			/* NE_IF UPDATE */
			neBeans.setNe_if_rslt_cd("SC");
			sendRepo.updateIF(neBeans);
			
			// TO-DO : user_org_lnkg insert (완료)
			HistoryBeans historyBeans = new HistoryBeans();
			historyBeans.setUser_id(authBeans.getUser_id());
			historyBeans.setOrg_id(authBeans.getOrg_id());
			historyBeans.setLnkg_yn("1");
			sendRepo.insertUserLnkg(historyBeans);
			
			return "Y";
			
		} else if(sendAttempt.getLinkYn().equals("N")) {
			/* NE_IF UPDATE (실패) */
			neBeans.setNe_if_rslt_cd("FA");
			sendRepo.updateIF(neBeans);
			
			return "N";
		
		} else {
			return "ERROR";
		}
	}

	// 데이터 조회 & 이력 생성 (업무코드 : H1)
	public String getHistory(final AuthBeans authBeans) {
		
		System.out.println("getHist 호출 >>>>>>");
		
		/* 개인별 연동여부 확인 */
		String lnkg_yn = sendRepo.getUserLnkg(authBeans.getUser_id());
		if (lnkg_yn.equals("1")){
			System.out.println("연동된 User 확인");
		} else if (lnkg_yn.equals("0")) {
			return "N";
		} else {
			System.out.println("알 수 없음 : " + lnkg_yn);
			return "N";
		}
		
		/* NE_IF insert */
		int req_num = sendRepo.getReqNum();
		NeBeans neBeans = new NeBeans();
		neBeans.setNe_if_cl_cd("OTH");
		neBeans.setChg_cd("H1");
		neBeans.setReq_ser_num(req_num);
		neBeans.setUser_id(authBeans.getUser_id());
		neBeans.setOrg_id(authBeans.getOrg_id());
		neBeans.setOp_ctt(authBeans.getId());
		sendRepo.insertIF(neBeans);
		
		/* 기부업체 : 조회 요청 */
		// 업체별 URL 확인
		String url = sendRepo.getURL(authBeans.getOrg_id());
		HistoryAttempt historyAttempt = sendAttempClient.callHistory(url, authBeans.getId());
		System.out.println(historyAttempt);
		/* NE_IF Update (완료) */
		neBeans.setNe_if_rslt_cd("SC");
		sendRepo.updateIF(neBeans);
		
		// TO-DO : 기부이력 추가 MS 호출 (bean list로 협의)
		// TO-DO : 포인트이력 관리  MS 호출 
		
		System.out.println("interface_receive 완료 >>>>>>");
		
		return "Y";

	}

}
