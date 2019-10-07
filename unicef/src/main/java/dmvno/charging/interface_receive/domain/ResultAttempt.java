package dmvno.charging.interface_receive.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * User 가 Multiplication 을 계산한 답안을 정의한 클래스
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class ResultAttempt {

	private final String linkYn;

	// JSON/JPA 를 위한 빈 생성자
	ResultAttempt() {
		linkYn = "N";
	}

}
