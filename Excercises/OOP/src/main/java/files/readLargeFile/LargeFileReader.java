package files.readLargeFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class LargeFileReader {
    private final Path path;
    private final int bufferSize;
    private final Linehandable linehandable;

    public LargeFileReader(Path path, int bufferSize, Linehandable linehandable) {
        this.path = path;
        this.bufferSize = bufferSize;
        this.linehandable = linehandable;
    }

    public void readLineByLine() {
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(String.valueOf(path)), bufferSize);
            String line;
            while (br.ready()) {
                line = br.readLine();
                linehandable.handleLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface Linehandable {
        void handleLine(String line);
    }
}
