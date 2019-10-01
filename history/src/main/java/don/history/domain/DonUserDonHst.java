package don.history.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data //getter, setter 자동 생성
public class DonUserDonHst {
	
	@Id
	private int		userId;				//사용자ID
	private String	donDt;				//기부일자
	private int		orgId;				//기부단체ID	
	private	String	rcvDtm;				//아력수신일시
	//@Column(name = "AUDIT_DMT", columnDefinition = "DATETIME")
	//@Temporal(TemporalType.TIMESTAMP)
	private	String	donAmt;				//기부금액
	private	String	insMthd;			//입력방식
	private	String	settlWayCd;			//결제수단코드
	private	String	payMthdCd;			//수납방법코드
	private	String	reguYn;				//정기여부
	private	String	donCtt;				//기부내용	
	private String	userNm;				//사용자명
	private String	orgNm;				//기부단체명
	private String	insMthdNm;			//입력방식
	private String	settlWayNm;			//결제수단
	private String	payMthdNm;			//수납방법
	private String	reguNm;				//정기여부

	public DonUserDonHst() {
		this.userId = 0; //default값 설정해줌
	}

	
}