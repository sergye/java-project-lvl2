package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private static final String PATH = "src/test/resources/";

    private static String getExpected(String pathFile)
            throws FileNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Path path = Paths.get(pathFile).toAbsolutePath().normalize();
        return new BufferedReader(new FileReader(path.toFile())).lines().collect(Collectors.joining("\n"));
    }

    @Test
    void getDiff1JsonTest()
            throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String file1 = PATH + "file1-1.json";
        String file2 = PATH + "file2-1.json";
        String expected = getExpected(PATH + "expected-stylish-simple.txt");

        assertEquals(expected, Differ.getDiff(file1, file2, "stylish"));
    }

    @Test
    void getDiff1YamlTest()
            throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String file1 = PATH + "file1-1.yaml";
        String file2 = PATH + "file2-1.yaml";
        String expected = getExpected(PATH + "expected-stylish-simple.txt");

        assertEquals(expected, Differ.getDiff(file1, file2, "stylish"));
    }

    @Test
    void getDiff2JsonTest()
            throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String file1 = PATH + "file1-2.json";
        String file2 = PATH + "file2-2.json";
        String expected = getExpected(PATH + "expected-stylish-nested.txt");

        assertEquals(expected, Differ.getDiff(file1, file2, "stylish"));
    }

    @Test
    void getDiff2YamlTest()
            throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String file1 = PATH + "file1-2.yaml";
        String file2 = PATH + "file2-2.yaml";
        String expected = getExpected(PATH + "expected-stylish-nested.txt");

        assertEquals(expected, Differ.getDiff(file1, file2, "stylish"));
    }

    @Test
    void getDiff1JsonPlainTest()
            throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String file1 = PATH + "file1-2.json";
        String file2 = PATH + "file2-2.json";
        String expected = getExpected(PATH + "expected-plain-nested.txt");

        assertEquals(expected, Differ.getDiff(file1, file2, "plain"));
    }

    @Test
    void getDiff2JsonPlainTest()
            throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String file1 = PATH + "file1-2.yaml";
        String file2 = PATH + "file2-2.yaml";
        String expected = getExpected(PATH + "expected-plain-nested.txt");

        assertEquals(expected, Differ.getDiff(file1, file2, "plain"));
    }

    @Test
    void getDiffJsonFormatTest()
            throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String file1 = PATH + "file1-1.json";
        String file2 = PATH + "file2-1.json";
        String expected = getExpected(PATH + "expected-plain-json.json");

        assertEquals(expected, Differ.getDiff(file1, file2, "json"));
    }
}
