package don.user.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import don.user.domain.DonUserInfo;

@Repository
@Mapper
public interface UserRepository {
	
	//MY포인트 조회
	DonUserInfo selectUserInfo(@Param("userLoginId") String userLoginId, @Param("userPassword") String userPassword);

}


