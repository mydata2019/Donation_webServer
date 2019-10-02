package dmvno.charging.interface_send.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 import dmvno.charging.interface_send.domain.HistoryBeans;
import dmvno.charging.interface_send.domain.NeBeans;

@Repository
@Mapper
public interface SendRepository {
	
	void insertIF(@Param("neBeans") NeBeans pbb);
	void updateIF(@Param("neBeans") NeBeans pbb);
	void insertUserLnkg(@Param("historyBeans") HistoryBeans pbb);
	String getUserLnkg(String user_id);
	String getURL(String org_id);
	int getReqNum();
}
