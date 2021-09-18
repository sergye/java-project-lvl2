package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Differ {

    public static String getDiff(String file1, String file2, String format) throws IOException {
        Map<String, Object> dataFile1 = Parser.parse(file1);
        Map<String, Object> dataFile2 = Parser.parse(file2);

        Set<String> matchingKeys = dataFile1.keySet().stream()
                .filter(dataFile2::containsKey)
                .collect(Collectors.toSet());

        Map<String, String> addedKeys = dataFile2.keySet().stream()
                .filter(x -> !matchingKeys.contains(x))
                .collect(Collectors.toMap(x -> x, y -> "added"));

        Map<String, String> deletedKeys = dataFile1.keySet().stream()
                .filter(x -> !matchingKeys.contains(x))
                .collect(Collectors.toMap(x -> x, y -> "deleted"));

        Map<String, String> diff = new TreeMap<>();
        diff.putAll(addedKeys);
        diff.putAll(deletedKeys);

        for (String key : matchingKeys) {
            if (Objects.equals(dataFile1.get(key), dataFile2.get(key))) {
                diff.put(key, "unchanged");
            } else {
                diff.put(key, "changed");
            }
        }

        DiffInfo diffInfo = new DiffInfo(dataFile1, dataFile2, diff);

        return Formatter.format(format, diffInfo);
    }
}
