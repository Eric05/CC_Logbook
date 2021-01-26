package countLinesOfCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\dev\\CC_Logbook");
        var extensions = new String[]{".java"};

        LineCounter lc = new LineCounter(start,extensions,false);
        System.out.println(lc.getCount());

    }


}
