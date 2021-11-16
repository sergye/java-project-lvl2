package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

import hexlet.code.Diff;

public class Json {
    private static final String TAB = "  ";

    public static String getFormat(List<Diff> diff) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        StringBuilder stringBuilder = new StringBuilder("[\n");

        for (Diff property : diff) {
            String json = mapper.writeValueAsString(property);
            stringBuilder.append(TAB);
            stringBuilder.append(json);
            stringBuilder.append(",\n");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("\n]");
        String result = stringBuilder.toString()
                .replace("{", "{\n" + TAB)
                .replace("}", "\n" + TAB + "}")
                .replace(":", ": ")
                .replace(",\"", ",\n" + TAB + "\"");

        return result;
    }
}
