package countLinesOfCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *  1. initialize with Path and String[] extensions
 *      e.g: Path start = Paths.get("C:\\dev\\exercices");
 *      var extensions = new String[]{".java"};
 *      LineCounter lc = new LineCounter(start,extensions);
 *   2. get count by lc.getCount()
 */

public class LineCounter {

    private final int count;

    public LineCounter(Path path, String[] extensions) {
        this.count = countLinesOfCode(path,extensions);
    }

    public int getCount() {
        return count;
    }

    private int countLinesOfCode(Path path, String[] extensions) {
        var files = getFiles(path);
        var filteredFiles = filterFilesByExtensions(files, extensions);
        int count = 0;

        for (Object javaFile : filteredFiles) {
            List<Object> filtered;

            var fileLines = readFileToList((Path.of(javaFile.toString())));
            filtered = filterNullLines(fileLines);
            count += filtered.size();
        }
        return count;
    }

    private List<String> getFiles(Path path) {
        var files = new ArrayList<String>();

        try (Stream<Path> stream = Files.walk(path, Integer.MAX_VALUE)) {
            List<String> collect = stream
                    .map(String::valueOf)
                    .sorted()
                    .collect(Collectors.toList());

            files.addAll(collect);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    private List<String> filterFilesByExtensions(List<String > files, String[] extensions) {
        var allFiles = new ArrayList<String>();

        for (String extension : extensions) {
            List<String> filesByExtension = files.stream()
                    .filter(f -> f.endsWith(extension))
                    .collect(Collectors.toList());

            allFiles.addAll(filesByExtension);
        }
        return allFiles;
    }

    private List<String> readFileToList(Path path) {
        ArrayList<String> result = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader(String.valueOf(path)))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Object> filterNullLines(List<String> files) {
        return files.stream()
                .filter(f -> !f.isEmpty())
                .collect(Collectors.toList());
    }
}
