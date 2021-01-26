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

/***
 *  1. initialize with Path and String[] extensions and boolean
 *   isNullLineAllowed (in case empty lines should be counted as well)
 *   e.g: Path start = Paths.get("C:\\dev\\exercices");
 *        var extensions = new String[]{".java"};
 *        LineCounter lc = new LineCounter(start, extensions, false);
 *   2. get count by lc.getCount()
 *
 *   Easiest way to read Files from file using charset
 *   Charset charset = Charset.forName("ISO-8859-1");
 *   List<String> result = Files.readAllLines(Paths.get(filename), charset);
 */

public class LineCounter {

    private final int count;

    public LineCounter(Path path, String[] extensions, boolean isNullLineAllowed) {
        this.count = countLinesOfCode(path, extensions, isNullLineAllowed);
    }

    public int getCount() {
        return count;
    }

    private int countLinesOfCode(Path path, String[] extensions, boolean isNullLineAllowed) {
        var files = getFiles(path);
        var filteredFiles = filterFilesByExtensions(files, extensions);
        var count = 0;

        for (var javaFile : filteredFiles) {
            var fileLines = readFileToList((Path.of(javaFile)));

            if (isNullLineAllowed) {
                count += fileLines.size();
            } else
                count += filterNullLines(fileLines).size();
        }
        return count;
    }

    private List<String> getFiles(Path path) {
        var files = new ArrayList<String>();

        try (var stream = Files.walk(path, Integer.MAX_VALUE)) {
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

    private List<String> filterFilesByExtensions(List<String> files, String[] extensions) {
        var allFiles = new ArrayList<String>();

        for (var extension : extensions) {
            List<String> filesByExtension = files.stream()
                    .filter(f -> f.endsWith(extension))
                    .collect(Collectors.toList());

            allFiles.addAll(filesByExtension);
        }
        return allFiles;
    }

    private List<String> readFileToList(Path path) {
        var result = new ArrayList<String>();

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
