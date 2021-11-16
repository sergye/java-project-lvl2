package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

public class Formatter {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static String format(String format, List<Diff> diff)
            throws JsonProcessingException, IllegalAccessException {
        switch (format) {
            case "stylish": return Stylish.getFormat(diff);
            case "plain": return Plain.getFormat(diff);
            case "json": return Json.getFormat(diff);
            default: return ("Unknown format! " + format);
        }
    }
}
