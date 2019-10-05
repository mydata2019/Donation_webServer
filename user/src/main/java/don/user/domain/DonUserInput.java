package don.user.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data //getter, setter 자동 생성
public class DonUserInput {
	
	@Id
	private String	userLoginId;		//사용자 로그인ID
	private String	userPassword;		//사용자 비밀번호

	
}