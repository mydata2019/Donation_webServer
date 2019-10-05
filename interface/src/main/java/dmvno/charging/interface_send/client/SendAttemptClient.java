package dmvno.charging.interface_send.client;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dmvno.charging.interface_send.client.dto.HistoryAttempt;
import dmvno.charging.interface_send.client.dto.SendAttempt;

/**
 * Multiplication 마이크로서비스와 REST 로 연결하기 위한
 * MultiplicationResultAttemptClient 인터페이스의 구현체
 */
@Component
public class SendAttemptClient {

  private final RestTemplate restTemplate;
  private final String receiveHost;

  @Autowired
  public SendAttemptClient(final RestTemplate restTemplate,
                                               @Value("${receiveHost}") final String receiveHost) {
    this.restTemplate = restTemplate;
    this.receiveHost = receiveHost;
  }

  public SendAttempt callAuth(final String url, final String id, final String pw) {
	  System.out.println("url : " + url);
	  System.out.println("IF송신값 : id = " + id + ", pw = " + pw);
	  
	  SendAttempt result = restTemplate.getForObject(url + "/auth/" + id + "/" + pw,
	            SendAttempt.class);
	  System.out.println(result);
    return result;
  }
  
  public List<HashMap<String,Object>> callHistory(final String url, final String id) {
	  System.out.println("url : " + url);
	  System.out.println("IF송신값 : id = " + id);
    return restTemplate.getForObject(url + "/getHistory/" + id,
    		List.class);
  }
}
