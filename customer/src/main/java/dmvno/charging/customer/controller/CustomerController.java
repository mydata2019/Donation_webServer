package dmvno.charging.customer.controller;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import dmvno.charging.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

//특정메소드만 JSON으로 반환할 경우엔 @ResponseBody을 사용
//전체클래스의 모든 메소드에서 JSON으로 반환할 경우 @RestController를 사용한다.
//@RestController
//@RequestMapping("/CustomerInfo")
//@RequestMapping("/html")
@Slf4j
@Controller
public class CustomerController {
 
 @Autowired
 private CustomerService customerService;
 
// /*
//  * @RequestMapping(value = "/demo2_1.html" , method = RequestMethod.POST) //
//  * public @ResponseBody CSR_SV_ACNT SelectCustInfo(@RequestBody String SVC_NUM)
//  * { public @ResponseBody ModelAndView SelectCustInfo(@RequestBody String
//  * SVC_NUM) {
//  * 
//  * // System.out.println("customer.controller ");
//  * 
//  * CSR_SV_ACNT result = new CSR_SV_ACNT(); result =
//  * customerService.SelectCustInfo(SVC_NUM);
//  * 
//  * System.out.println(result); ModelAndView mv = new ModelAndView();
//  * mv.setViewName("/static/html/demo2_1"); // 뷰의 이름 //
//  * mv.setViewName("jsonView"); mv.addObject("result", result); // 뷰로 보낼 데이터 값
//  * 
//  * System.out.println(mv); // return result; return mv;
//  * 
//  * }
//  */
 @Value ( "${addr.webserver}")
 private String ADDR_WEBSERVER;
 
 @RequestMapping("/customerInfo")
 public @ResponseBody  HashMap<String, Object> getResultLast(@RequestBody String SVC_NUM) {
	  
	 HashMap<String, String> result = new HashMap<String,String>();
	 HashMap<String, Object> result_final = new HashMap<String,Object>();

	 result = customerService.SelectCustInfo(SVC_NUM);
	 result_final.put("SV_ACNT_NUM", result.get("SV_ACNT_NUM"));
	 result_final.put("MVNO_CO_CD", result.get("MVNO_CO_CD"));
	 result_final.put("SVC_NUM", result.get("SVC_NUM"));
	 result_final.put("SV_ACNT_ST_CD", result.get("SV_ACNT_ST_CD"));
	 result_final.put("CUST_NM", result.get("CUST_NM"));
	 result_final.put("SYS_DATE", result.get("SYSDATE"));
	 result_final.put("PROD_NM", result.get("PROD_NM"));
	 
	 System.out.println("result_final : "     + result_final);
	 
	 return result_final;
 }
 
 @SuppressWarnings("unused")
 @RequestMapping(value = "/get_svc_info" , method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody ModelAndView SelectCustInfo(String SVC_NUM) {
   
   System.out.println("customer.controller : " + SVC_NUM);
   
   HashMap<String, String> result = new HashMap<String,String>();
   result = customerService.SelectCustInfo(SVC_NUM);
  
   System.out.println("rusult : "     + result);
   
   ModelAndView mv = new ModelAndView();
   
   try {
   if(result.get("MVNO_CO_CD").equals("M00030"))
    {
     RedirectView rv = new RedirectView(ADDR_WEBSERVER+"jsp/demo2_1.jsp");
     
     mv.addAllObjects(result);
     mv.setView(rv);
    }
    else if(result.get("MVNO_CO_CD").equals("M00070"))
    {
     RedirectView rv = new RedirectView(ADDR_WEBSERVER+"jsp/demo2_2.jsp");
     mv.addAllObjects(result);
     mv.setView(rv);
    }
   }
   catch(Exception e)
   {
    mv.setViewName("redirect:"+ADDR_WEBSERVER+"jsp/demo1.jsp");
    return mv;
   }
      
   System.out.println(mv);
   return mv;
   }
}
