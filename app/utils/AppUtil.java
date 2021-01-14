package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class AppUtil {

    public static ObjectNode createResponse(Object response, boolean flag) {
        ObjectNode createdResponse = Json.newObject();
        createdResponse.put("status", flag);
        if (response instanceof String) {
            createdResponse.put("response", (String) response);
        }
        else {
            createdResponse.set("response", (JsonNode) response);
        }
        return createdResponse;
    }
}
