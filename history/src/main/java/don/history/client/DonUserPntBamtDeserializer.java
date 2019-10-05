package don.history.client;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;

public class DonUserPntBamtDeserializer
        extends JsonDeserializer<DonUserPntBamt> {

  @Override
  public DonUserPntBamt deserialize(JsonParser jsonParser,
                                                 DeserializationContext deserializationContext)
          throws IOException, JsonProcessingException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    return new DonUserPntBamt(node.get("userId").asInt(),
    		node.get("bamtClCd").asText(),
    		node.get("pntBamt").asText(),
    		node.get("auditDtm").asText(),
    		node.get("bamtClNm").asText());

  }
}
