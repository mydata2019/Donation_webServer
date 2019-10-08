package don.statistics.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import don.statistics.domain.StatisticsParams;

@Repository
@Mapper
public interface StatisticsRepository {
	
	int selectTotalAmt(@Param("userId") int userId);
	//MY기부통계 조회
	List<HashMap<String, Object>> selectColStatistics(@Param("userId") int userId);
//	HashMap<String,Object> selectHistory(@Param("userId") String userId);
	List<HashMap<String, Object>> selectCatStatistics(@Param("userId") int userId);

	List<HashMap<String, Object>> selectPieStatistics(@Param("userId") int userId);
	
}


