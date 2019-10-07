package don.history.client;

import java.util.HashMap;

/**
 * point와 연결하는 인터페이스
 * 통신 방식은 상관 없음
 */
public interface PointIf {

	DonUserPntBamt selectPntBamt (String userId);
	String callInsertPoint(final HashMap<String, Object> history);
}
