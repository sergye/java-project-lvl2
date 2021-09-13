package hexlet.code;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format",
            defaultValue = "stylish", showDefaultValue = CommandLine.Help.Visibility.ALWAYS)
    private String format;

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to the first file")
    private String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to the second file")
    private String filepath2;

    @Override
    public Integer call() {
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}