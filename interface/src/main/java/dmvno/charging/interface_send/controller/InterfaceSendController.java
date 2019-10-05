package dmvno.charging.interface_send.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dmvno.charging.interface_send.client.dto.HistoryAttempt;
import dmvno.charging.interface_send.domain.AuthBeans;
import dmvno.charging.interface_send.domain.HistoryBeans;
import dmvno.charging.interface_send.service.InterfaceSendService;

/**
 * 사용자가 POST 로 답안을 전송하도록 REST API 를 제공하는 클래스
 */
@RestController
@RequestMapping("/Interface")
final class InterfaceSendController {

	private final InterfaceSendService interfaceSendService;

	@Autowired
	public InterfaceSendController(final InterfaceSendService interfaceSendService) {
		this.interfaceSendService = interfaceSendService;
	}

	@RequestMapping("/Auth")
	ResponseEntity<String> sendAuthMessage(@RequestBody AuthBeans authBeans) {
		System.out.println("Auth ----" + authBeans);

		String linkYn = interfaceSendService.checkAuth(authBeans);

		return ResponseEntity.ok(linkYn);
	}

	@RequestMapping("/GetDonation")
	ResponseEntity<String> sendHistoryMessage(@RequestBody AuthBeans authBeans) {
		System.out.println("GetDonation ----" + authBeans);

		String getYn = interfaceSendService.getHistory(authBeans);

		return ResponseEntity.ok(getYn);
	}
	
	@RequestMapping("/GetLnkg")
	ResponseEntity<List<HistoryBeans>> sendLnkgMessage(@RequestBody AuthBeans authBeans) {
		System.out.println("GetLnkg ----" + authBeans);

		List<HistoryBeans> lnkg = interfaceSendService.getLnkg(authBeans);

		return ResponseEntity.ok(lnkg);
	}
}
