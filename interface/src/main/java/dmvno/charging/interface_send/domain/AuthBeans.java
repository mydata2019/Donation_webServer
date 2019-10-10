package dmvno.charging.interface_send.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Data
public final class AuthBeans {

	/* 넘겨주는 값은 final 처리. notNull 도 final 후 임의값 추가 */
	private String org_id;
	private String user_id;
	private String id;
	private String pw;
	private String linkYn;

}
