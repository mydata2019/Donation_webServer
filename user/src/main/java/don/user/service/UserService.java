package don.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * MY기부내역
 */
public interface UserService {

	boolean confirmUserInfo(String userLoginId, String userPassword); 
  
}
