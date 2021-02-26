package csv;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class CsvUtil {

    public static List<String> readCsvToList(Path path) {

        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Logger.log(Logger.LogType.ERROR, "Error loading the csv " + path.toString() + e.getMessage());
        }
        return null;
    }

    public static <T> void writeToCsv(Path path, List<T> dtos) throws IOException {
        for (T d : dtos) {
            appendText(d.toString(), String.valueOf(path));
        }
    }

    public static void appendText(String text, String des) throws IOException {
        FileWriter fw = null;

        try {
            fw = new FileWriter(des, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(text);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            Logger.getInstance();
            Logger.log(Logger.LogType.ERROR, "Error when writing to File");
        }
        finally {
            fw.close();
        }
    }

    public static void loadCsvByLine(Path file, Consumer<String> doWork) {
        Scanner csvFile;

        try {
            csvFile = new Scanner(file, StandardCharsets.UTF_8);
            while (csvFile.hasNextLine()) {
                var line = csvFile.nextLine();
                if (line.length() > 0) {
                    doWork.accept(line);
                }
            }
            csvFile.close();
        } catch (IOException e) {
            Logger.getInstance();
            Logger.log(Logger.LogType.ERROR, "Error loading the csv " + file.toString() + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
