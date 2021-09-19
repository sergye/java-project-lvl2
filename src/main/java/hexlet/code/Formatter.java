package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

public class Formatter {

    public static String format(String format, DiffInfo diffInfo) throws JsonProcessingException {
        switch (format) {
            case "stylish": return Stylish.format(diffInfo);
            case "plain": return Plain.format(diffInfo);
            case "json": return Json.format(diffInfo);
            default: return "Unknown out format";
        }
    }
}
