package don.history.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 출전이력 조회
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class DonUserInfoMain {

	private final List<HashMap<String, Object>> hstResult;
	private final String pntBamt;

  // JSON/JPA 를 위한 빈 생성자
	DonUserInfoMain() {
		hstResult = new ArrayList<HashMap<String, Object>>();
		pntBamt= "";

  }
	
}
