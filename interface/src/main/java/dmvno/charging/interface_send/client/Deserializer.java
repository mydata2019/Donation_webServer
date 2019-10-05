package dmvno.charging.interface_send.client;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import dmvno.charging.interface_send.client.dto.SendAttempt;

import java.io.IOException;

/**
 * Multiplication 마이크로서비스로부터 오는 답안을
 * Gamification 에서 사용하는 형태로 역직렬화
 */
public class Deserializer
        extends JsonDeserializer<SendAttempt> {

  @Override
  public SendAttempt deserialize(JsonParser jsonParser,
                                                 DeserializationContext deserializationContext)
          throws IOException, JsonProcessingException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    return new SendAttempt(node.get("linkYn").asText());
  }
}
