package hexlet.code.formatters;

import hexlet.code.Diff;

public enum Stylish {
    ADDED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) {
            stringBuilder
                    .append("\t").append("+ ")
                    .append(property.getName())
                    .append(": ")
                    .append(property.getAfter())
                    .append("\n");
        }
    },

    DELETED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) {
            stringBuilder
                    .append("\t")
                    .append("- ")
                    .append(property.getName())
                    .append(": ")
                    .append(property.getBefore())
                    .append("\n");
        }
    },

    UNCHANGED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) {
            stringBuilder
                    .append("\t")
                    .append("  ")
                    .append(property.getName())
                    .append(": ")
                    .append(property.getBefore())
                    .append("\n");
        }
    },

    CHANGED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) {
            stringBuilder
                    .append("\t")
                    .append("- ")
                    .append(property.getName())
                    .append(": ")
                    .append(property.getBefore())
                    .append("\n")
                    .append("\t").append("+ ")
                    .append(property.getName())
                    .append(": ")
                    .append(property.getAfter())
                    .append("\n");
        }
    };

    public abstract void appendProperty(Diff property, StringBuilder stringBuilder);
}
