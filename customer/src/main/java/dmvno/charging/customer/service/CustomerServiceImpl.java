package dmvno.charging.customer.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dmvno.charging.customer.domain.CSR_SV_ACNT;
import dmvno.charging.customer.mapper.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;

	@Override
//	public CSR_SV_ACNT SelectCustInfo(String SVC_NUM) {
	public HashMap<String,String> SelectCustInfo(String SVC_NUM) {
		// TODO Auto-generated method stub
		
		System.out.println("[Impl]Svc_num : " + SVC_NUM);
//		CSR_SV_ACNT result = customerRepository.SelectCustInfo(SVC_NUM);
		HashMap<String,String> result = customerRepository.SelectCustInfo(SVC_NUM);
		
//		System.out.println(result);
		return result;
	}

	@Override
	public String getDual() throws Exception {
		// TODO Auto-generated method stub
		return customerRepository.getDual();
	}
}
