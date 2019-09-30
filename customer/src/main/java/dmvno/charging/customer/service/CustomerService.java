package dmvno.charging.customer.service;

import java.util.HashMap;

import dmvno.charging.customer.domain.CSR_SV_ACNT;

public interface CustomerService {
	
//	CustomerDomain SelectCustInfo(String SV_ACNT_NUM);
	
	public HashMap<String, String> SelectCustInfo(String SV_ACNT_NUM);
	
	public String getDual() throws Exception;
}
