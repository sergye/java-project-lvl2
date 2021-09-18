package hexlet.code.formatters;

import java.util.Map;
import hexlet.code.DiffInfo;

public class Stylish {
    private static final String TAB = "\t";


    public static String format(DiffInfo diffInfo) {
        Map<String, Object> dataFile1 = diffInfo.getDataFile1();
        Map<String, Object> dataFile2 = diffInfo.getDataFile2();
        Map<String, String> diff = diffInfo.getDiff();
        StringBuilder result = new StringBuilder("{\n");

        for (Map.Entry<String, String> key : diff.entrySet()) {
            switch (key.getValue()) {
                case "added":
                    result.append(TAB).append("+ ").append(key.getKey()).append(": ")
                            .append(dataFile2.get(key.getKey())).append("\n");
                    break;
                case "deleted":
                    result.append(TAB).append("- ").append(key.getKey()).append(": ")
                            .append(dataFile1.get(key.getKey())).append("\n");
                    break;
                case "unchanged":
                    result.append(TAB).append("  ").append(key.getKey()).append(": ")
                            .append(dataFile1.get(key.getKey())).append("\n");
                    break;
                case "changed":
                    result.append(TAB).append("- ").append(key.getKey()).append(": ")
                            .append(dataFile1.get(key.getKey())).append("\n")
                            .append(TAB).append("+ ").append(key.getKey()).append(": ")
                            .append(dataFile2.get(key.getKey())).append("\n");
                    break;
                default: System.out.println("Unknown format");
            }
        }
        return result.append("}").toString();
    }
}
