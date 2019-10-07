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
 * Multiplication 마이크로서비스와 REST 로 연결하기 위한 MultiplicationResultAttemptClient
 * 인터페이스의 구현체
 */
@Component
public class SendAttemptClient {

	private final RestTemplate restTemplate;
	private final String historyHost;
	private final String pointHost;

	@Autowired
	public SendAttemptClient(final RestTemplate restTemplate, @Value("${historyHost}") final String historyHost,
			@Value("${pointHost}") final String pointHost) {
		this.restTemplate = restTemplate;
		this.historyHost = historyHost;
		this.pointHost = pointHost;
	}

	public SendAttempt callAuth(final String url, final String id, final String pw) {
		System.out.println("url : " + url);
		System.out.println("IF송신값 : id = " + id + ", pw = " + pw);

		SendAttempt result = restTemplate.getForObject(url + "/auth/" + id + "/" + pw, SendAttempt.class);
		System.out.println(result);
		return result;
	}

	public List<HashMap<String, Object>> callHistory(final String url, final String id) {
		System.out.println("url : " + url);
		System.out.println("IF송신값 : id = " + id);
		return restTemplate.getForObject(url + "/getHistory/" + id, List.class);
	}

	public String callInsertHistory(final List<HashMap<String, Object>> history) {
		System.out.println("historyHost : " + historyHost);
		System.out.println("IF송신값 : history = " + history);
		return restTemplate.postForObject(historyHost + "/history/insertHistory/", history, String.class);
	}

	public String callInsertPoint(final HashMap<String, Object> history) {
		System.out.println("pointHost : " + pointHost);
		System.out.println("IF송신값 : history = " + history);
		return restTemplate.postForObject(pointHost + "/point/insert/", history, String.class);
	}
}
