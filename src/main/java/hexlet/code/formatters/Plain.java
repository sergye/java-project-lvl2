package hexlet.code.formatters;

import hexlet.code.Diff;

public enum Plain {
    ADDED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) {
            stringBuilder
                    .append("Property '")
                    .append(property.getName())
                    .append("' was added with value: ")
                    .append(Stringifier.stringify(property.getAfter()))
                    .append("\n");
        }
    },

    DELETED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) {
            stringBuilder
                    .append("Property '")
                    .append(property.getName())
                    .append("' was removed\n");
        }
    },

    UNCHANGED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) {
            stringBuilder.append("");
        }
    },

    CHANGED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) {
            stringBuilder
                    .append("Property '")
                    .append(property.getName())
                    .append("' was updated. From ")
                    .append(Stringifier.stringify(property.getBefore()))
                    .append(" to ")
                    .append(Stringifier.stringify(property.getAfter()))
                    .append("\n");
        }
    };

    public abstract void appendProperty(Diff property, StringBuilder stringBuilder);

}

