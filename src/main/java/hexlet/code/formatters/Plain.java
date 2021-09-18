package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;
import hexlet.code.DiffInfo;

public class Plain {

    public static String format(DiffInfo diffInfo) {
        Map<String, Object> dataFile1 = diffInfo.getDataFile1();
        Map<String, Object> dataFile2 = diffInfo.getDataFile2();
        Map<String, String> diff = diffInfo.getDiff();
        StringBuilder result = new StringBuilder("");

        for (Map.Entry<String, String> key : diff.entrySet()) {
            switch (key.getValue()) {
                case "added":
                    result.append("Property '").append(key.getKey()).append("' was added with value: ")
                            .append(stringify(dataFile2.get(key.getKey()))).append("\n");
                    break;
                case "deleted":
                    result.append("Property '").append(key.getKey()).append("' was removed\n");
                    break;
                case "unchanged":
                    break;
                case "changed":
                    result.append("Property '").append(key.getKey()).append("' was updated. From ")
                            .append(stringify(dataFile1.get(key.getKey())))
                            .append(" to ").append(stringify(dataFile2.get(key.getKey()))).append("\n");
                    break;
                default: System.out.println("Unknown format");
            }
        }
        return result.toString();
    }

    private static Object stringify(Object object) {
        return object instanceof Object[] || object instanceof Collection || object instanceof Map
                ? "[complex value]"
                : object instanceof String
                ? "'" + object + "'"
                : object;
    }
}