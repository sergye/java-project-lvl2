package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

public class Formatter {

    public static String format(String format, DiffInfo diffInfo) {

        switch (format) {
            case "stylish": return Stylish.format(diffInfo);
            case "plain": return Plain.format(diffInfo);
            default: return "Unknown out format";
        }
    }
}
