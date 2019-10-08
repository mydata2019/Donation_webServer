package don.statistics.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import don.statistics.domain.StatisticsParams;

/**
 * MY기부내역
 */
public interface StatisticsService {

//  List<HashMap<String, Object>> selectStatistics(int userId);
	StatisticsParams selectStatistics(int userId);
	
  
}
