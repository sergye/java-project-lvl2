package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DiffGenerator {
    public static String getDiff(String file1, String file2) throws IOException {
        return getDiff("stylish", file1, file2);
    }

    public static String getDiff(String format, String file1, String file2) throws IOException {
        Map<String, Object> parsedDataFromFile1 = Parser.parse(file1);
        Map<String, Object> parsedDataFromFile2 = Parser.parse(file2);
        Map<String, String> diff = generateDiff(parsedDataFromFile1, parsedDataFromFile2);
        return Formatter.format(diff, parsedDataFromFile1, parsedDataFromFile2);
    }

    private static Map<String, String> generateDiff(Map<String, Object> dataFromFile1,
                                                    Map<String, Object> dataFromFile2) {

        Set<String> matchingKeys = dataFromFile1.keySet().stream()
                .filter(dataFromFile2::containsKey)
                .collect(Collectors.toSet());

        Map<String, String> addedKeys = dataFromFile2.keySet().stream()
                .filter(x -> !matchingKeys.contains(x))
                .collect(Collectors.toMap(x -> x, y -> "added"));

        Map<String, String> deletedKeys = dataFromFile1.keySet().stream()
                .filter(x -> !matchingKeys.contains(x))
                .collect(Collectors.toMap(x -> x, y -> "deleted"));

        Map<String, String> diff = new TreeMap<>(addedKeys);
        diff.putAll(deletedKeys);

        for (String key : matchingKeys) {
            if (Objects.equals(dataFromFile1.get(key), dataFromFile2.get(key))) {
                diff.put(key, "unchanged");
            } else {
                diff.put(key, "changed");
            }
        }
        return diff;
    }
}
