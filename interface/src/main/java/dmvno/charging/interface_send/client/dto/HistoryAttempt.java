package dmvno.charging.interface_send.client.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import dmvno.charging.interface_send.client.Deserializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User 가 Multiplication 을 계산한 답안을 정의한 클래스
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = Deserializer.class)
public final class HistoryAttempt {

  private final List<Map<String,Object>> history;

  // JSON/JPA 를 위한 빈 생성자
  HistoryAttempt() {
	  history = null;
  }
  
  
  
}
