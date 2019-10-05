package dmvno.charging.interface_receive.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dmvno.charging.interface_receive.domain.HistoryResultAttempt;
import dmvno.charging.interface_receive.domain.ResultAttempt;
import dmvno.charging.interface_receive.service.InterfaceReceiveService;

/**
 * 사용자가 POST 로 답안을 전송하도록 REST API 를 제공하는 클래스
 */
@RestController
@RequestMapping("/api")
final class InterfaceReceiveController {

	private final InterfaceReceiveService interfaceReceiveService;

	@Autowired
	public InterfaceReceiveController(final InterfaceReceiveService interfaceReceiveService) {
		this.interfaceReceiveService = interfaceReceiveService;
	}

	@GetMapping("/auth/{id}/{pw}")
	ResponseEntity<ResultAttempt> receiveMessage(final @PathVariable("id") String id,
			final @PathVariable("pw") String pw) {

		System.out.println("id =>>>>>>>>" + id + "pw =>>>>>>>>" + pw);
		String authYn = interfaceReceiveService.checkAuth(id, pw);

		ResultAttempt authResult = new ResultAttempt(authYn);
		System.out.println("응답보내기 : " + authYn + ", " + authResult);
		return ResponseEntity.ok(authResult);
	}

	@GetMapping("/getHistory/{id}")
	ResponseEntity<List<HashMap<String, Object>>> receiveMessage2(final @PathVariable("id") String id) {

		System.out.println("id =>>>>>>>>" + id);

		List<HashMap<String, Object>> history = interfaceReceiveService.getHistory(id);
		HistoryResultAttempt receivedBean = new HistoryResultAttempt(history);
		
		System.out.println(history);
		System.out.println(receivedBean);
		
		return ResponseEntity.ok(history);
	}
}
