package don.history.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import don.history.domain.DonUserDonHst;

@Repository
@Mapper
public interface HistoryRepository {
	
	//MY기부이력 조회(명세)
	List<Map<String, Object>> selectHistorySpc(@Param("userId") int userId);

	//MY기부이력 조회(상세)
	List<Map<String, Object>> selectHistory(@Param("userId") int userId);
}


