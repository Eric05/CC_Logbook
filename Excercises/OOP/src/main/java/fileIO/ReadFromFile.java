package fileIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class ReadFromFile {

    public static List<String> readSmallFileToList(String src) throws IOException {
        try {
            return Files.readAllLines(Path.of(src));
        } catch (IOException e) {
            ErrorLogger.getInstance();
            ErrorLogger.writeError("Error when reading file");
        }
        return null;
    }

    public static String readFileToString(String src) throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(src));
        } catch (FileNotFoundException e) {
            ErrorLogger.getInstance();
            ErrorLogger.writeError("Error when reading file");
        }
        while ((line = Objects.requireNonNull(br).readLine()) != null) {
            sb.append(line).append("\n");
        }

        br.close();
        return sb.toString();
    }

    // using org.apache.commons.io.FileUtils;
    public static List<String> readLinesFromFile(String path) {
        try {
            return FileUtils.readLines(new File(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // read large file line by line with apache...
    // using plain java we could use Inputstream and Scanner
    public static void readLargeFileByLine(File file) throws IOException {

        try (LineIterator it = FileUtils.lineIterator(file, "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                // do something with line
            }
        }
    }
}
