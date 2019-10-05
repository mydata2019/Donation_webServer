package don.history.client;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 한 번 혹은 여러 번의 게임 결과를 포함하는 객체
 * {@link ScoreCard} 객체와 {@link BadgeCard} 로 이루어짐
 * 게임 한 번에 변경된 내용 또는 점수와 배지 전체를 나타낼 때 사용됨
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = DonUserPntBamtDeserializer.class)
public final class DonUserPntBamt {
	
	private final int		userId;				//사용자ID
	private final String	bamtClCd;			//잔액구분코드
	private final String	pntBamt;			//포인트 잔액	
	private	final String	auditDtm;			//최종수정일시
	private final String	bamtClNm;			//잔액구분

	public DonUserPntBamt() {		
		userId = 0;
		bamtClCd = "";
		pntBamt = "";
		auditDtm = "";
		bamtClNm = "";
	
	}
}