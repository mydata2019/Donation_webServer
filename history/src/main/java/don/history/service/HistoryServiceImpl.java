package don.history.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import don.history.client.DonUserPntBamt;
import don.history.client.PointIf;
import don.history.domain.DonUserDonHst;
import don.history.domain.DonUserInfoMain;
import don.history.mapper.HistoryRepository;

@Service
@Slf4j
class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryRepository histRepo; //repository
	private PointIf pntIf;
	
	public HistoryServiceImpl(PointIf pntIf) {
		this.pntIf = pntIf;
	}
	
	public DonUserInfoMain selectHistory(String userId) {

		int id = Integer.parseInt(userId);		
		List<HashMap<String, Object>> hstResult = null;
//		HashMap<String, Object> pntResult = null;
		String pntBamt = "";
		
		//1. 기부이력 조회
		hstResult = histRepo.selectHistory(id);
		
		//2. 포인트 잔액 조회(Rest API 호출)
		DonUserPntBamt pntResult = pntIf.selectPntBamt(userId);	
		pntBamt = pntResult.getPntBamt();
		
        return new DonUserInfoMain(hstResult, pntBamt);

	}

	public String insertHistory(List<HashMap<String, Object>> donationHistory, String gubun) {

		System.out.println("insert Service 시작");
		for (HashMap<String, Object> a : donationHistory) {
			a.put("INS_MTHD", gubun); // REL01: 직접입력, REL02: API연동
			histRepo.insertHistory(a);
		}

		System.out.println("insert 완료");
		
        return "SC";

	}
	
}
