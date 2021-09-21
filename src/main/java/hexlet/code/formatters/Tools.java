package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;

public class Tools {

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
    }

    public static String getEnding(String format, StringBuilder stringBuilder) {
        if (format.equals("stylish")) {
            stringBuilder.append("}");
        }
        return stringBuilder.toString().trim();
    }
}
