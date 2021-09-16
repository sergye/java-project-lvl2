package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DiffGenerator {

    public static String getDiff(String filepath1, String filepath2) throws IOException {
        return getDiff("stylish", filepath1, filepath2);
    }

    public static String getDiff(String format, String filepath1, String filepath2) throws IOException {
        Map<String, Object> file1 = Parser.parseFile(new File(filepath1));
        Map<String, Object> file2 = Parser.parseFile(new File(filepath2));

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
            checkDiff(diff, key, value1, value2);
        }
        diff.append("\n}");
        return diff.toString();
    }

    private static void checkDiff(StringBuilder diff, String key, String value1, String value2) {
        if (value1 != "" && value1.equals(value2)) {
            writeDiff(diff, " ", key, value1);
        } else {
            if (value1 != "") {
                writeDiff(diff, "-", key, value1);
            }
            if (value2 != "") {
                writeDiff(diff, "+", key, value2);
            }
        }
    }

    private static void writeDiff(StringBuilder diff, String sign, String key, String value) {
        diff.append(String.format("\n\t%s %s: %s", sign, key, value));
    }
}
