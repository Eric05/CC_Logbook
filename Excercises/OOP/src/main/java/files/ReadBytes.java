package files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadBytes {
    public static Path basePath = Paths.get(System.getProperty("user.dir"));

    public static void main(String[] args) throws IOException {
        String path = String.valueOf(basePath.resolve("Persons.txt"));

        // file to byte[]
        byte[] bytes = Files.readAllBytes(Paths.get(path));

        for (byte b : bytes) {
            System.out.print(b + " ");
        }

        // byte[] to String
        var s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
