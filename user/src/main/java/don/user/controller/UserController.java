package don.user.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import don.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
//@Controller //json형식으로 데이터 송수신
@RestController //json형식으로 데이터 송수신
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;	

	@Autowired
	  public UserController(final UserService userService) {
	    this.userService = userService;
	}
	
	// MY기부내역 조회
	@RequestMapping("/confirm")
	public @ResponseBody ModelAndView selectMyPoint(String userLoginId, String userPassword) {
		
		ModelAndView mav = new ModelAndView();
		String url = "";
		String ip = "localhost";

		System.out.println("userLoginId : "+ userLoginId);
		boolean result = userService.confirmUserInfo(userLoginId, userPassword);
		System.out.println("result : " + result);
		
		if(result == true) {
			url="redirect:http://"+ip+":8080/jsp/mainMyDon.jsp";
		}else {
			url="redirect:http://"+ip+":8080/jsp/login.jsp";
		}
		
		mav.setViewName(url);
		mav.addObject("userId", 1);  
		  
		return mav;
		
	}
	

}



