package don.statistics.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;//check
import lombok.ToString;


//@Data //getter, setter 자동 생성
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class StatisticsParams {

	private final int totalAmt;
	private final List<HashMap<String, Object>> colRslt; 
	private final List<HashMap<String, Object>> catRslt; 
	private final List<HashMap<String, Object>> pieRslt;
	
	StatisticsParams() {
//		this.userId = 0; //default값 설정해줌
		totalAmt = 0;
		colRslt = new ArrayList<HashMap<String, Object>>();
		catRslt = new ArrayList<HashMap<String, Object>>();
		pieRslt = new ArrayList<HashMap<String, Object>>();
		
	}

	
}