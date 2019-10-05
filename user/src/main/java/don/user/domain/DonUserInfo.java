package don.user.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data //getter, setter 자동 생성
public class DonUserInfo {
	
	@Id
	private int		userId;				//사용자ID
	private String	userLoginId;		//사용자 로그인ID
	private String	userPassword;		//사용자 비밀번호
	private	String	userNm;				//사옹자명
	private String	userSvcNum;			//사용자 연락처
	private String	userResidence;		//사용자 거주지역
	private String	userMarriedYn;		//사용자 결혼여부
	private	String	userInterest1;		//사용자 관심사1
	private String	userInterest2;		//사용자 관심사2	
	private String	userInterest3;		//사용자 관심사3
	private String	userMarriedNm;		//사용자 결혼여부
	private	String	userInterest1Nm;	//사용자 관심사1
	private String	userInterest2Nm;	//사용자 관심사2	
	private String	userInterest3Nm;	//사용자 관심사3


	public DonUserInfo() {
		this.userId = 0; //default값 설정해줌
	}

	
}