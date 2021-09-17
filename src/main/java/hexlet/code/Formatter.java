package hexlet.code;

import java.util.Map;

public class Formatter {
    public static final String TAB = "\t";

    public static String format(Map<String, String> diff, Map<String, Object> file1, Map<String, Object> file2) {

        StringBuilder result = new StringBuilder("{\n");

        for (Map.Entry<String, String> key : diff.entrySet()) {
            switch (key.getValue()) {
                case "added":
                    result.append(TAB).append("+ ").append(key.getKey()).append(": ")
                        .append(file2.get(key.getKey())).append("\n");
                    break;
                case "deleted":
                    result.append(TAB).append("- ").append(key.getKey()).append(": ")
                        .append(file1.get(key.getKey())).append("\n");
                    break;
                case "unchanged":
                    result.append(TAB).append("  ").append(key.getKey()).append(": ")
                        .append(file1.get(key.getKey())).append("\n");
                    break;
                case "changed":
                    result.append(TAB).append("- ").append(key.getKey()).append(": ")
                        .append(file1.get(key.getKey())).append("\n")
                        .append(TAB).append("+ ").append(key.getKey()).append(": ")
                        .append(file2.get(key.getKey())).append("\n");
                    break;
                default: System.out.println("Unknown format");
            }
        }
        return result.append("}").toString();
    }
}
