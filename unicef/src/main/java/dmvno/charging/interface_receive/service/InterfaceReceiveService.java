package dmvno.charging.interface_receive.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dmvno.charging.interface_receive.domain.InterfaceBeans;
import dmvno.charging.interface_receive.mapper.ReceiveRepository;

@Service
public class InterfaceReceiveService {

	@Autowired
	private ReceiveRepository receiveRepo; //repository


	public String checkAuth(String id, String pw) {
		
		System.out.println("checkAuth");
		InterfaceBeans bean = new InterfaceBeans();
		bean.setLogin_id(id);
		bean.setPassword(pw);
		int cnt = receiveRepo.checkAuth(bean);
		
		if (cnt>=1) {
			return "Y";
		} else {
			return "N";
		}
	}

	public List<HashMap<String, Object>> getHistory(String id) {

		System.out.println("getHistory");
		List<HashMap<String, Object>> result = receiveRepo.getHistory(id);

		return result;
	}

}
