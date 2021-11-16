
package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String contents, String type) throws IOException {
        return getObjectMapper(type).readValue(contents, new TypeReference<>() {
        });
    }

    private static ObjectMapper getObjectMapper(String fileName) {
        if (fileName.endsWith(".json")) {
            return new ObjectMapper();
        } else {
            return new ObjectMapper(new YAMLFactory());
        }
    }
}
