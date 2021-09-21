package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;

public class Tools {
    private static final String TAB = "  ";
    private static String result;

    public static Object stringify(Object object) {
        return object instanceof Object[] || object instanceof Collection || object instanceof Map
                ? "[complex value]"
                : object instanceof String
                ? "'" + object + "'"
                : object;
    }

    public static void getHeader(String format, StringBuilder stringBuilder) {
        if (format.equals("stylish")) {
            stringBuilder.append("{\n");
        }

        if (format.equals("json")) {
            stringBuilder.append("[\n");
        }
    }

    public static String getEnding(String format, StringBuilder stringBuilder) {
        if (format.equals("stylish")) {
            stringBuilder.append("}");
        }

        if (format.equals("json")) {
            stringBuilder.setLength(stringBuilder.length() - 2);
            stringBuilder.append("\n]");
            result = stringBuilder.toString()
                    .replace("{", "{\n" + TAB)
                    .replace("}", "\n" + TAB + "}")
                    .replace(":", ": ")
                    .replace(",\"", ",\n" + TAB + "\"");
        } else {
            result = stringBuilder.toString().trim();
        }

        return result;
    }
}
