package don.statistics.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import don.statistics.domain.StatisticsParams;
import don.statistics.mapper.StatisticsRepository;

@Service
@Slf4j
class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private StatisticsRepository statisticsRepo; //repository
	
//	public List<HashMap<String, Object>> selectStatistics(int userId) {
	public StatisticsParams selectStatistics(int userId) {
		
		int totalAmt = statisticsRepo.selectTotalAmt(userId);
		System.out.println("StatisticsInput total result >> "+totalAmt);
		List<HashMap<String, Object>> colRslt = statisticsRepo.selectColStatistics(userId);
		System.out.println("StatisticsInput col result >> "+colRslt);
		List<HashMap<String, Object>> catRslt = statisticsRepo.selectCatStatistics(userId);
		System.out.println("StatisticsInput cat result >> "+catRslt);		
		
		List<HashMap<String, Object>> pieRslt = statisticsRepo.selectPieStatistics(userId);
		System.out.println("StatisticsInput pie result >> "+pieRslt);
		
		return new StatisticsParams(totalAmt, colRslt, catRslt, pieRslt);
	}

	
}