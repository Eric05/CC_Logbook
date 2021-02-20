package fileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class ReadFromFile {

    public static List<String> readSmallFileToList(String src) throws IOException {
        return Files.readAllLines(Path.of(src));
    }

    public static String readFileToString(String src) throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(src));
        } catch (FileNotFoundException e) {
            ErrorLogger.writeError("Error when reading file");
        }
        while ((line = Objects.requireNonNull(br).readLine()) != null) {
            sb.append(line).append("\n");
        }

        br.close();
        return sb.toString();
    }
}
