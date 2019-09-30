package dmvno.charging.customer.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import dmvno.charging.customer.domain.CSR_SV_ACNT;

@Repository
@Mapper
public interface CustomerRepository {
	
	public String getDual() throws Exception;

	public HashMap<String, String> SelectCustInfo(@Param("SVC_NUM") String SVC_NUM);
//	public CSR_SV_ACNT SelectCustInfo(String SVC_NUM);
}
