package don.history.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import don.history.client.DonUserPntBamt;
import don.history.client.PointIf;
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
		List<Map<String, Object>> hstResult = null;
		List<Map<String, Object>> hstResultSpc = null;
//		HashMap<String, Object> pntResult = null;
		String pntBamt = "";
		
		//1. MY기부이력 조회(명세)
		hstResultSpc = histRepo.selectHistorySpc(id);

		//1. MY기부이력 조회(상세)
		hstResult = histRepo.selectHistory(id);
		
		//2. 포인트 잔액 조회(Rest API 호출)
		DonUserPntBamt pntResult = pntIf.selectPntBamt(userId);	
		pntBamt = pntResult.getPntBamt();
		
        return new DonUserInfoMain(hstResultSpc, hstResult, pntBamt);

	}

	
}
