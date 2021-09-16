package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiffGeneratorTest {

    private static final String DIFF = "{\n"
            + "\t- follow: false\n"
            + "\t  host: hexlet.io\n"
            + "\t- proxy: 123.234.53.22\n"
            + "\t- timeout: 50\n"
            + "\t+ timeout: 20\n"
            + "\t+ verbose: true\n"
            + "}";

    @Test
    void getDiffJsonTest() throws IOException {

        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";

        assertEquals(DIFF, DiffGenerator.getDiff(file1, file2));
    }

    @Test
    void getDiffYamlTest() throws IOException {

        String file1 = "src/test/resources/file1.yaml";
        String file2 = "src/test/resources/file2.yaml";

        assertEquals(DIFF, DiffGenerator.getDiff(file1, file2));
    }

}
