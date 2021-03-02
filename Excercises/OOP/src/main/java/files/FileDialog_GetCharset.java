package files;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDialog_GetCharset {

    public static void main(String[] args) throws IOException {

        String path = "";
        var file = Paths.get(System.getProperty("user.dir")).resolve("HW");
        path = getPathByFileDialog(path);

        BufferedReader br = new BufferedReader(new FileReader(path));
        var firstLine = "";
        while (br.readLine().isEmpty()) {
            br.readLine();
        }

        firstLine = br.readLine();
        String[] sets = new String[]{"utf-8", "utf-16"};
        var charset = getCharset(firstLine, sets);

        //var lines = Files.readAllLines(Path.of(path), Charset.forName(charset));

        System.out.println("Charset is: " + charset);
    }

    public static String getPathByFileDialog(String path) {
        FileDialog fd = new FileDialog(new JFrame());
        fd.setVisible(true);
        File[] f = fd.getFiles();
        if (f.length > 0) {
            path = (fd.getFiles()[0].getAbsolutePath());
        }
        return path;
    }

    public static String getCharset(String value, String[] charsets) throws UnsupportedEncodingException {
        String probe = StandardCharsets.UTF_8.name();
        for (String c : charsets) {
            Charset charset = Charset.forName(c);
            if (value.equals(convert(convert(value, charset.name(), probe), probe, charset.name()))) {
                return c;
            }
        }
        return StandardCharsets.UTF_8.name();
    }

    private static String convert(String value, String fromEncoding, String toEncoding) throws UnsupportedEncodingException {
        return new String(value.getBytes(fromEncoding), toEncoding);
    }
}
