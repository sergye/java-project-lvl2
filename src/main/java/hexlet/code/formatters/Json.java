package hexlet.code.formatters;

import hexlet.code.Diff;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum Json {

    ADDED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) throws JsonProcessingException {
            String json = mapper.writeValueAsString(property);
            stringBuilder.append(TAB);
            stringBuilder.append(json);
            stringBuilder.append(",\n");
        }
    },

    DELETED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) throws JsonProcessingException {
            String json = mapper.writeValueAsString(property);
            stringBuilder.append(TAB);
            stringBuilder.append(json);
            stringBuilder.append(",\n");
        }
    },

    UNCHANGED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) throws JsonProcessingException {
            String json = mapper.writeValueAsString(property);
            stringBuilder.append(TAB);
            stringBuilder.append(json);
            stringBuilder.append(",\n");
        }
    },

    CHANGED {
        @Override
        public void appendProperty(Diff property, StringBuilder stringBuilder) throws JsonProcessingException {
            String json = mapper.writeValueAsString(property);
            stringBuilder.append(TAB);
            stringBuilder.append(json);
            stringBuilder.append(",\n");
        }
    };

    private static final String TAB = "  ";
    private static ObjectMapper mapper = new ObjectMapper();

    public abstract void appendProperty(Diff property, StringBuilder stringBuilder) throws JsonProcessingException;

}
