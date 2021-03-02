package files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

/* Aufgabe File schreiben:
1. Hello World.txt auf Desktop anlegen und "Hello World!" einschreiben.
2. Wenn Hello World.txt schon existiert, dann Hallo World 2.txt, Hello World 3.txt, usw erstellen.
// Stack Overflow
List<String> files = Arrays.asList("Hello2", "Hello3", "Hello1", "Hello7");
        Set<Integer> usedIndexes = files.stream() // extract numeric
        .map(s -> s.replaceAll("\\D+", ""))
        .map(Integer::parseInt)
        .collect(Collectors.toSet()); // store in set

        int first = files.stream() // find first index not in set
        .filter(index -> !usedIndexes.contains(index))
        .findFirst()
        .orElse(names.size());*/

public class WriteTextFile {

    public static Path basePath = Paths.get(System.getProperty("user.dir")).resolve("HW");

    public static void main(String[] args) throws IOException {

        List<String> lines = Arrays.asList(new String[]{"A;200", "B;122", "A;120", "B;40"});
        Files.write(basePath.resolve("country"), lines);

               addFile("Hello World");
    }

    public static void addFile(String text) throws IOException {
        List<String> files = getFilesByName("Hello");
        int index = getIndex(files);

        Path path = basePath.resolve("Hello" + index + ".txt");
        writeTextToFile(path, text + " -> " + index);
    }

    private static int getIndex(List<String> files) {
        int first = files.stream()
                .mapToInt(s -> Integer.parseInt(s.substring(5, s.indexOf(".txt"))))
                .collect(BitSet::new, BitSet::set, BitSet::or).nextClearBit(1);
        return first;
    }

    private static List<String> getFilesByName(String name) throws IOException {
        var files = Files.walk(basePath);

        List<String> result = files
                .map(f -> f.getFileName())
                .map(f -> f.toString())
                .filter(f -> f.contains(name))
                .collect(Collectors.toList());

        return result;
    }

    private static void writeTextToFile(Path path, String text) throws IOException {
        FileWriter fw = new FileWriter(String.valueOf(path));
        fw.write(text);
    }
}
