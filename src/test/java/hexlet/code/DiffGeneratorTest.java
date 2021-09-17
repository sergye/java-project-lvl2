package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiffGeneratorTest {

    private static final String DIFF1 = "{\n"
            + "\t- follow: false\n"
            + "\t  host: hexlet.io\n"
            + "\t- proxy: 123.234.53.22\n"
            + "\t- timeout: 50\n"
            + "\t+ timeout: 20\n"
            + "\t+ verbose: true\n"
            + "}";

    private static final String DIFF2 = "{\n"
            + "\t  chars1: [a, b, c]\n"
            + "\t- chars2: [d, e, f]\n"
            + "\t+ chars2: false\n"
            + "\t- checked: false\n"
            + "\t+ checked: true\n"
            + "\t- default: null\n"
            + "\t+ default: [value1, value2]\n"
            + "\t- id: 45\n"
            + "\t+ id: null\n"
            + "\t- key1: value1\n"
            + "\t+ key2: value2\n"
            + "\t  numbers1: [1, 2, 3, 4]\n"
            + "\t- numbers2: [2, 3, 4, 5]\n"
            + "\t+ numbers2: [22, 33, 44, 55]\n"
            + "\t- numbers3: [3, 4, 5]\n"
            + "\t+ numbers4: [4, 5, 6]\n"
            + "\t+ obj1: {nestedKey=value, isNested=true}\n"
            + "\t- setting1: Some value\n"
            + "\t+ setting1: Another value\n"
            + "\t- setting2: 200\n"
            + "\t+ setting2: 300\n"
            + "\t- setting3: true\n"
            + "\t+ setting3: none\n"
            + "}";

    @Test
    void getDiff1JsonTest() throws IOException {

        String file1 = "src/test/resources/file1-1.json";
        String file2 = "src/test/resources/file2-1.json";

        assertEquals(DIFF1, DiffGenerator.getDiff(file1, file2));
    }

    @Test
    void getDiff1YamlTest() throws IOException {

        String file1 = "src/test/resources/file1-1.yaml";
        String file2 = "src/test/resources/file2-1.yaml";

        assertEquals(DIFF1, DiffGenerator.getDiff(file1, file2));
    }
    @Test
    void getDiff2JsonTest() throws IOException {

        String file1 = "src/test/resources/file1-2.json";
        String file2 = "src/test/resources/file2-2.json";

        assertEquals(DIFF2, DiffGenerator.getDiff(file1, file2));
    }

    @Test
    void getDiff2YamlTest() throws IOException {

        String file1 = "src/test/resources/file1-2.yaml";
        String file2 = "src/test/resources/file2-2.yaml";

        assertEquals(DIFF2, DiffGenerator.getDiff(file1, file2));
    }
}
