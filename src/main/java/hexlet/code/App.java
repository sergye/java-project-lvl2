package hexlet.code;

import java.util.concurrent.Callable;
import java.io.IOException;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"},
            defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to the first file")
    private String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to the second file")
    private String filepath2;

    @Override
    public Integer call() throws IOException {
        System.out.println(DiffGenerator.getDiff(format, filepath1, filepath2));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
