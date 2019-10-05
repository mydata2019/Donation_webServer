package dmvno.charging.interface_receive.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
public final class HistoryResultAttempt {

	private final List<HashMap<String, Object>> history;
	
	// JSON/JPA 를 위한 빈 생성자
	HistoryResultAttempt() {
		history = null;
	}

}
