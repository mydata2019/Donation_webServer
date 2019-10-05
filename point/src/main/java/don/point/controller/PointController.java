package don.point.controller;


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

import don.point.domain.DonUserPntBamt;
import don.point.service.PointService;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
//@Controller //json형식으로 데이터 송수신
@RestController //json형식으로 데이터 송수신
@RequestMapping("/point")
public class PointController {

	@Autowired
	private PointService pntService;	

	@Autowired
	  public PointController(final PointService pntService) {
	    this.pntService = pntService;
	}
	
	// MY기부내역 조회
	@RequestMapping("/select")
	public @ResponseBody DonUserPntBamt selectMyPoint(@RequestBody String userId) {

		System.out.println("userId : "+ userId);
		DonUserPntBamt result = pntService.selectPntBamt(userId);
		System.out.println("result : " + result);
		
		return result;
		
	}
	

}



