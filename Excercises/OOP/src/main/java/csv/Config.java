package csv;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {

    public static final Path BASE_PATH = Paths.get(System.getProperty("user.dir"));
    public static final Path LOG_PATH = BASE_PATH.resolve("error.txt");
    public static final Path CSV_PATH = BASE_PATH.resolve("covid19.csv");
    public static final Path OUTPUT_PATH = BASE_PATH.resolve("top.txt");
    public static final String INPUT_DELIM = ",";
    public static final String OUT_DELIM = ";";
}
