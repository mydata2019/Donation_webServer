package don.history.client;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * I/F send MSA와 REST API 로 연결하기 위한 인터페이스의 구현체
 */
@Component
class ExecutePointIf implements PointIf {

	@Autowired
	private final RestTemplate restTemplate;
	private String pointHost;
	private HttpHeaders headers;

	@Autowired
	public ExecutePointIf(final RestTemplate restTemplate, @Value("${pointHost}") final String pointHost) {
		this.restTemplate = restTemplate;
		this.pointHost = pointHost;
		this.headers = new HttpHeaders();

	}

	public DonUserPntBamt selectPntBamt(final String userId) {

		String sendURL = "";
		headers.setContentType(MediaType.APPLICATION_JSON);

		sendURL = pointHost + "/point/select";
		HttpEntity request = new HttpEntity(userId, headers);
		System.out.println("request : " + sendURL + "/" + request);

		DonUserPntBamt rslt = restTemplate.postForObject(sendURL, request, DonUserPntBamt.class);
		System.out.println("rslt >> " + rslt);

		return rslt;
	}

	public String callInsertPoint(final HashMap<String, Object> history) {
		System.out.println("pointHost : " + pointHost);
		System.out.println("IF송신값 : history = " + history);
		return restTemplate.postForObject(pointHost + "/point/insert/", history, String.class);
	}

}
