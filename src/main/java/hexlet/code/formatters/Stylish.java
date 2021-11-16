package hexlet.code.formatters;

import hexlet.code.Diff;
import java.util.List;

public class Stylish {

    public static String getFormat(List<Diff> diff) {

        StringBuilder stringBuilder = new StringBuilder("{\n");

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
                    appendUnchangedProperty(property, stringBuilder);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static void appendAddedProperty(Diff property, StringBuilder stringBuilder) {
        stringBuilder
                .append("  ")
                .append("+ ")
                .append(property.getName())
                .append(": ")
                .append(property.getAfter())
                .append("\n");
    }

    private static void appendDeletedProperty(Diff property, StringBuilder stringBuilder) {
        stringBuilder
                .append("  ")
                .append("- ")
                .append(property.getName())
                .append(": ")
                .append(property.getBefore())
                .append("\n");
    }

    private static void appendUnchangedProperty(Diff property, StringBuilder stringBuilder) {
        stringBuilder
                .append("  ")
                .append("  ")
                .append(property.getName())
                .append(": ")
                .append(property.getBefore())
                .append("\n");
    }

    private static void appendChangedProperty(Diff property, StringBuilder stringBuilder) {
        stringBuilder
                .append("  ")
                .append("- ")
                .append(property.getName())
                .append(": ")
                .append(property.getBefore())
                .append("\n")
                .append("  ").append("+ ")
                .append(property.getName())
                .append(": ")
                .append(property.getAfter())
                .append("\n");
    }
}
