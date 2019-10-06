package don.point.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import don.point.domain.DonUserPntBamt;

@Repository
@Mapper
public interface PointRepository {
	
	//MY포인트 조회
	DonUserPntBamt selectPntBamt(@Param("userId") int userId);
	//MY포인트 추가
	void updatePntBamt(HashMap<String, Object> pointMap);
}


