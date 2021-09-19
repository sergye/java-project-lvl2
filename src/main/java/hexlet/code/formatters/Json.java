package hexlet.code.formatters;

import java.util.Map;
import hexlet.code.DiffInfo;

public class Json {
    private static final String TAB = "  ";

    public static String format(DiffInfo diffInfo) {
        Map<String, Object> dataFile1 = diffInfo.getDataFile1();
        Map<String, Object> dataFile2 = diffInfo.getDataFile2();
        Map<String, String> diff = diffInfo.getDiff();

        StringBuilder result = new StringBuilder("{\n");

        for (Map.Entry<String, String> key : diff.entrySet()) {
            String field = key.getKey();
            Object file1Value = dataFile1.get(key.getKey());
            Object file2Value = dataFile2.get(key.getKey());

            switch (key.getValue()) {
                case "added":
                    result
                            .append(TAB).append("{\n")
                            .append(TAB).append("\"field\": ").append("\"" + field + "\"").append(",\n")
                            .append(TAB).append("\"before\": ").append("null").append(",\n")
                            .append(TAB).append("\"after\": ").append(Stringifier.stringify(file2Value)).append("\n")
                            .append(TAB).append("},\n");
                    break;
                case "deleted":
                    result
                            .append(TAB).append("{\n")
                            .append(TAB).append("\"field\": ").append("\"" + field + "\"").append(",\n")
                            .append(TAB).append("\"before\": ").append(Stringifier.stringify(file1Value)).append(",\n")
                            .append(TAB).append("\"after\": ").append("null").append("\n")
                            .append(TAB).append("},\n");
                    break;
                case "unchanged":
                    result
                            .append(TAB).append("{\n")
                            .append(TAB).append("\"field\": ").append("\"" + field + "\"").append(",\n")
                            .append(TAB).append("\"before\": ").append(Stringifier.stringify(file1Value)).append(",\n")
                            .append(TAB).append("\"after\": ").append(Stringifier.stringify(file1Value)).append("\n")
                            .append(TAB).append("},\n");
                    break;
                case "changed":
                    result
                            .append(TAB).append("{\n")
                            .append(TAB).append("\"field\": ").append("\"" + field + "\"").append(",\n")
                            .append(TAB).append("\"before\": ").append(Stringifier.stringify(file1Value)).append(",\n")
                            .append(TAB).append("\"after\": ").append(Stringifier.stringify(file2Value)).append("\n")
                            .append(TAB).append("},\n");
                    break;
                default: System.out.println("Unknown format");
            }
        }
        result.setLength(result.length() - 2);
        result.append("\n}");

        return result.toString().replace("'", "\"").trim();
    }

}
