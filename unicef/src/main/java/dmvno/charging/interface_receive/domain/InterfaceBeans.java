package dmvno.charging.interface_receive.domain;

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
public final class InterfaceBeans {

	
	/*넘겨주는 값은 final 처리. notNull 도 final 후 임의값 추가 */
  private  String login_id;
  private  String password;
  private  String don_dt;
  private  int don_amt;
  private  String settl_way_cd;
  private  String pay_mthd_cd;
  private  String regu_yn;
  private  String don_ctt;
  
}
