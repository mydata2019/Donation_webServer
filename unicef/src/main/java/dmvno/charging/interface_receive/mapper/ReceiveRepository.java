package dmvno.charging.interface_receive.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dmvno.charging.interface_receive.domain.InterfaceBeans;



@Repository
@Mapper
public interface ReceiveRepository {
	
	int checkAuth(@Param("interfaceBeans") InterfaceBeans interfaceBeans);
	List<HashMap<String, Object>> getHistory(@Param("id") String id);
}
