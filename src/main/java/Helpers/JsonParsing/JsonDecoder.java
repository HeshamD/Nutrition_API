package Helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class JsonDecoder {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();
    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper =  new ObjectMapper();
        // -- Json configuration
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return defaultObjectMapper;
    }
    public static JsonNode JsonParser(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }
    public static<T> T fromJson(JsonNode node, Class<T> tClass) throws JsonProcessingException {
        return objectMapper.treeToValue(node,tClass);
    }

    public static JsonNode toJson(Object a){
        return objectMapper.valueToTree(a);
    }
    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateString(node,false);
    }
    public static String prettyPrint(JsonNode node) throws JsonProcessingException {
        return generateString(node,true);
    }

    public static String generateString(JsonNode node,boolean pretty) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        if (pretty)
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        return objectWriter.writeValueAsString(node);
    }
}
