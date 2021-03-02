package files;

import files.readLargeFile.LargeFileReader;
import files.readLargeFile.SimpleLineHandler;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LargeFileReader.Linehandable lh = new SimpleLineHandler();
         Path basePath = Paths.get(System.getProperty("user.dir"));
         Path path = basePath.resolve("Persons.txt");

        LargeFileReader lfr = new LargeFileReader(path, 8192, lh);
        lfr.readLineByLine();
        System.out.println(((SimpleLineHandler) lh).getList().size());
    }

}
