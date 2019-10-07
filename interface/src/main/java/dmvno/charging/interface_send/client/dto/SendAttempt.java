package dmvno.charging.interface_send.client.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import dmvno.charging.interface_send.client.Deserializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User 가 Multiplication 을 계산한 답안을 정의한 클래스
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class SendAttempt {

	private final String linkYn;

	// JSON/JPA 를 위한 빈 생성자
	SendAttempt() {
		linkYn = "N";
	}

}
