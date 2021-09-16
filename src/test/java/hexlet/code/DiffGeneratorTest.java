package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiffGeneratorTest {

    private static final String DIFF = "{\n"
            + "  - follow: false\n"
            + "    host: hexlet.io\n"
            + "  - proxy: 123.234.53.22\n"
            + "  - timeout: 50\n"
            + "  + timeout: 20\n"
            + "  + verbose: true\n"
            + "}";

    @Test
    void getDiffTest() throws IOException {

        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";

        assertEquals(DIFF, DiffGenerator.getDiff(file1, file2));
    }

}
