package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Tools;

public class Formatter {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static String format(String format, List<Diff> diff)
            throws JsonProcessingException, NoSuchMethodException, IllegalAccessException, InvocationTargetException  {
        switch (format) {
            case "stylish": return getFormat(Stylish.class, diff, format);
            case "plain": return getFormat(Plain.class, diff, format);
            case "json": return Json.getFormat(diff);
            default: return ("Unknown format! " + format);
        }
    }

    private static <E extends Enum<E>> String getFormat(Class<E> formatter, List<Diff> diff, String format)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Tools.getHeader(format, stringBuilder);

        for (Diff property : diff) {
            E status = (E) Enum.valueOf(formatter, property.getStatus().toUpperCase());
            Method method = status.getClass().getMethod("appendProperty", Diff.class, StringBuilder.class);
            method.setAccessible(true);
            method.invoke(status, property, stringBuilder);
        }

        String result = Tools.getEnding(format, stringBuilder);
        stringBuilder.setLength(0);
        diff.clear();

        return result;
    }
}
