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
public final class NeBeans {

	/* 넘겨주는 값은 final 처리. notNull 도 final 후 임의값 추가 */
	private String ne_if_cl_cd;
	private String req_dt;
	private int req_ser_num;
	private Date fst_cre_dtm;
	private Date audit_dtm;
	private String chg_cd;
	private String user_id;
	private String org_id;
	private String op_ctt;
	private String ne_if_rslt_cd;
	private String ne_if_err_cd;
	private int orgl_req_ser_num;

}
