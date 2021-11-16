package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.TreeSet;
import java.lang.reflect.InvocationTargetException;

public class Differ {
    public static String generate(String file1, String file2)
            throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return generate(file1, file2, "stylish");
    }

    public static String generate(String file1, String file2, String format)
            throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map<String, Object> dataFile1 = Parser.parse(getFileContent(file1), file1);
        Map<String, Object> dataFile2 = Parser.parse(getFileContent(file2), file2);
        Set<String> keys = getKeySet(dataFile1, dataFile2);
        List<Diff> diff = keys.stream()
                .map(x -> getDiffProperty(x, dataFile1, dataFile2))
                .collect(Collectors.toList());
        return Formatter.format(format, diff);
    }

    private static Diff getDiffProperty(String key, Map<String, Object> dataFile1, Map<String, Object> dataFile2) {
        if (!dataFile1.containsKey(key) && dataFile2.containsKey(key)) {
            return new Diff(key, "added", null, dataFile2.get(key));
        }
        if (dataFile1.containsKey(key) && !dataFile2.containsKey(key)) {
            return new Diff(key, "deleted", dataFile1.get(key), null);
        }
        if (!Objects.equals(dataFile1.get(key), dataFile2.get(key))) {
            return new Diff(key, "changed", dataFile1.get(key), dataFile2.get(key));
        }
        return new Diff(key, "unchanged", dataFile1.get(key), dataFile2.get(key));
    }

    public static Set<String> getKeySet(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keySet = new TreeSet<>(map1.keySet());
        keySet.addAll(map2.keySet());
        return keySet;
    }

    public static String getFileContent(String fileName) throws IOException {
        return Files.readString(Paths.get(fileName).toAbsolutePath().normalize());
    }
}
