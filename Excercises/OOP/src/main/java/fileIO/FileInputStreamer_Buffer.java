package fileIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileInputStreamer_Buffer {

    public static String readFileBetterPerformance(String fileName, int buffer) {

        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(fileName)) {

            byte[] bytes = new byte[buffer];

            while (fis.read(bytes) != -1) {
                sb.append(new String(bytes, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
