package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

public class Formatter {
    private static String diffFormat;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static String format(String format, List<Diff> diff)
            throws JsonProcessingException, NoSuchMethodException, IllegalAccessException, InvocationTargetException  {
        diffFormat = format;
        switch (format) {
            case "stylish": return getFormat(Stylish.class, diff);
            case "plain": return getFormat(Plain.class, diff);
            case "json": return Json.format(diff);
            default: return "Unknown out format";
        }
    }

    private static <E extends Enum<E>> String getFormat(Class<E> formatter, List<Diff> diff)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (diffFormat.equals("stylish")) {
            stringBuilder.append("{\n");
        }

        for (Diff property : diff) {
            E status = (E) Enum.valueOf(formatter, property.getStatus().toUpperCase());
            Method method = status.getClass().getMethod("appendProperty", Diff.class, StringBuilder.class);
            method.setAccessible(true);
            method.invoke(status, property, stringBuilder);
        }

        if (diffFormat.equals("stylish")) {
            stringBuilder.append("}");
        }

        String result = stringBuilder.toString().trim();
        stringBuilder.setLength(0);
        diff.clear();

        return result;
    }
}
