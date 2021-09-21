package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.lang.reflect.InvocationTargetException;

public class Differ {
    private static List<Diff> diff = new ArrayList<>();

    public static String getDiff(String file1, String file2, String format)
            throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map<String, Object> dataFile1 = Parser.parse(file1);
        Map<String, Object> dataFile2 = Parser.parse(file2);

        Set<String> matchingKeys = dataFile1.keySet().stream()
                .filter(dataFile2::containsKey)
                .collect(Collectors.toSet());

        dataFile2.entrySet().stream()
                .filter(x -> !matchingKeys.contains(x.getKey()))
                .forEach(x -> addToDiff(x.getKey(), "added", null,  x.getValue()));

        dataFile1.entrySet().stream()
                .filter(x -> !matchingKeys.contains(x.getKey()))
                .forEach(x -> addToDiff(x.getKey(), "deleted", x.getValue(), null));

        matchingKeys.stream()
                .filter(x -> Objects.equals(dataFile1.get(x), dataFile2.get(x)))
                .forEach(x -> addToDiff(x, "unchanged",  dataFile1.get(x), dataFile1.get(x)));

        matchingKeys.stream()
                .filter(x -> !Objects.equals(dataFile1.get(x), dataFile2.get(x)))
                .forEach(x -> addToDiff(x, "changed", dataFile1.get(x), dataFile2.get(x)));

        diff.sort(Comparator.comparing(Diff::getName));

        return Formatter.format(format, diff);
    }

    private static void addToDiff(String name, String status, Object before, Object after) {
        Diff property = new Diff(name, status, before, after);
        diff.add(property);
    }
}
