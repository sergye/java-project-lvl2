package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DiffGenerator {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String getDiff(String filepath1, String filepath2) throws IOException {
        return getDiff("stylish", filepath1, filepath2);
    }

    public static String getDiff(String format, String filepath1, String filepath2) throws IOException {
        Map<String, Object> file1 = MAPPER.readValue(new File(filepath1), Map.class);
        Map<String, Object> file2 = MAPPER.readValue(new File(filepath2), Map.class);

        List<String> keys = new ArrayList<>(new HashSet<>() {{
            addAll(file1.keySet());
            addAll(file2.keySet());
        }});
        keys.sort(String::compareTo);

        StringBuilder diff = new StringBuilder();
        diff.append("{");
        for (String key : keys) {
            String value1 = file1.containsKey(key) ? file1.get(key).toString() : "";
            String value2 = file2.containsKey(key) ? file2.get(key).toString() : "";
            if (value1 != "" && value2 != "" && value1.equals(value2)) {
                addValue(diff, " ", key, value1);
            } else {
                if (value1 != "") {
                    addValue(diff, "-", key, value1);
                }
                if (value2 != "") {
                    addValue(diff, "+", key, value2);
                }
            }
        }
        diff.append("\n}");
        return diff.toString();
    }

    private static void addValue(StringBuilder diff, String sign, String key, String value) {
        diff.append(String.format("\n\t%s %s: %s", sign, key, value));
    }
}
