package hexlet.code.formatters;

import hexlet.code.Diff;
import java.util.List;

public class Plain {

    public static String getFormat(List<Diff> diff) {

        StringBuilder stringBuilder = new StringBuilder();

        for (Diff property : diff) {
            switch (property.getStatus()) {
                case "added":
                    appendAddedProperty(property, stringBuilder);
                    break;
                case "deleted":
                    appendDeletedProperty(property, stringBuilder);
                    break;
                case "changed":
                    appendChangedProperty(property, stringBuilder);
                    break;
                default:
                    stringBuilder.append("");
            }
        }
        return stringBuilder.toString().trim();
    }

    private static void appendAddedProperty(Diff property, StringBuilder stringBuilder) {
        stringBuilder
                .append("Property '")
                .append(property.getName())
                .append("' was added with value: ")
                .append(Tools.stringify(property.getAfter()))
                .append("\n");
    }

    private static void appendDeletedProperty(Diff property, StringBuilder stringBuilder) {
        stringBuilder
                .append("Property '")
                .append(property.getName())
                .append("' was removed\n");
    }

    private static void appendChangedProperty(Diff property, StringBuilder stringBuilder) {
        stringBuilder
                .append("Property '")
                .append(property.getName())
                .append("' was updated. From ")
                .append(Tools.stringify(property.getBefore()))
                .append(" to ")
                .append(Tools.stringify(property.getAfter()))
                .append("\n");
    }
}
