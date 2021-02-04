package countLinesOfCode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\dev\\CC_Logbook");
        var extensions = new String[]{".java"};

        LineCounter lc = new LineCounter(start, extensions, false);
        System.out.println(lc.getCount());

    }


}
