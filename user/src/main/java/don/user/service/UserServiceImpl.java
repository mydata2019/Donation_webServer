package don.user.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import don.user.domain.DonUserInfo;
import don.user.mapper.UserRepository;

@Service
@Slf4j
class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo; //repository
	
	public int confirmUserInfo(String userLoginId, String userPassword) {
		
		int result = 0;
		
		try
		{			
			DonUserInfo resultData = userRepo.selectUserInfo(userLoginId, userPassword);
			int id = resultData.getUserId();
			
			if(id > 0) {
				result = id;
			}			

		} catch (Exception e) {
			// TODO: handle exception
			result = 0;
		
		} finally {
			// TODO: handle finally clause
			return result;

		}

	}

	
	
	
}
