package don.point.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data //getter, setter 자동 생성
public class DonUserPntBamt {
	
	@Id
	private int		userId;				//사용자ID
	private String	bamtClCd;			//잔액구분코드
	private String	pntBamt;			//포인트 잔액	
	private	String	auditDtm;			//최종수정일시
	private String	bamtClNm;			//잔액구분

	public DonUserPntBamt() {
		this.userId = 0; //default값 설정해줌
	}

	
}