package dmvno.charging.interface_send.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	private SendRepository sendRepo; // repository

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

		/* 기부업체 - 인증 */
		// 업체별 URL 확인
		String url = sendRepo.getURL(authBeans.getOrg_id());
		// 기부업체 LOGIN
		SendAttempt sendAttempt = sendAttempClient.callAuth(url, authBeans.getId(), authBeans.getPw());

		System.out.println("auth 로부터의 응답 : " + sendAttempt.getLinkYn());

		if (sendAttempt.getLinkYn().equals("Y")) {
			/* NE_IF UPDATE */
			neBeans.setNe_if_rslt_cd("SC");
			sendRepo.updateIF(neBeans);

			// user_org_lnkg insert (완료)
			HistoryBeans historyBeans = new HistoryBeans();
			historyBeans.setUser_id(authBeans.getUser_id());
			historyBeans.setOrg_id(authBeans.getOrg_id());
			historyBeans.setLnkg_yn("2");
			sendRepo.insertUserLnkg(historyBeans);

			System.out.println("checkAuth 완료 >>>>>>");
			return "Y";

		} else if (sendAttempt.getLinkYn().equals("N")) {
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
//		HistoryAttempt historyAttempt = sendAttempClient.callHistory(url, authBeans.getId());
		List<HashMap<String, Object>> history = sendAttempClient.callHistory(url, authBeans.getId());

		System.out.println(history);
		/* NE_IF Update (완료) */
		neBeans.setNe_if_rslt_cd("SC");
		sendRepo.updateIF(neBeans);

		System.out.println("getDonationHistory 완료 >>>>>>");

		/* 기부이력 추가 MS 호출 (bean list로 협의) */
		List<HashMap<String, Object>> requestSet1 = history;
		for (HashMap<String, Object> a : requestSet1) {
			a.put("USER_ID", authBeans.getUser_id());
			a.put("ORG_ID", authBeans.getOrg_id());
		}
		String ack = sendAttempClient.callInsertHistory(requestSet1);
		System.out.println("callInsertHistory 완료 >>>>>>" + ack);

		
		/* 포인트 추가는 history로 이동
		// 포인트이력 관리 MS 호출 
		int addDon = 0;
		for (HashMap<String, Object> a : history) {
			addDon = addDon + Integer.parseInt(a.get("DON_AMT").toString());
		}
		HashMap<String, Object> requestSet2 = new HashMap<String, Object>();
		requestSet2.put("USER_ID", authBeans.getUser_id());
		requestSet2.put("BAMT_CL_CD", "DON01");
		requestSet2.put("ADD_DON_AMT", addDon);
		
		System.out.println("addDon >> " + addDon);
		String ack2 = sendAttempClient.callInsertPoint(requestSet2);
		System.out.println("callInsertPoint 완료 >>>>>>" + ack2);
		*/
		
		return "Y";

	}

	// 데이터 조회 & 이력 생성 (업무코드 : H1)
	public List<HistoryBeans> getLnkg(final AuthBeans authBeans) {

		System.out.println("getLnkg 호출 >>>>>>");

		/* 개인별 연동여부 확인 */
		List<HistoryBeans> result = sendRepo.getUserLnkg(authBeans.getUser_id());

		System.out.println("getLnkg 완료 >>>>>>");

		return result;

	}

}
