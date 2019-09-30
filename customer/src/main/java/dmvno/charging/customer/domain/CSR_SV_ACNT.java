package dmvno.charging.customer.domain;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

@Data
public class CSR_SV_ACNT {
	@Id
	private String CUST_NM;
	private String MVNO_CO_CD;
	private String SV_ACNT_ST_CD;
	private String PROD_NM;
	private String SVC_NUM;
	private String SV_ACNT_NUM;
	private String SYSDATE;
	
	public CSR_SV_ACNT() {
		this.SV_ACNT_NUM = "111111111";
	}
}
