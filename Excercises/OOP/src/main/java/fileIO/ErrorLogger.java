package fileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorLogger {
    final static String PATH = "C:\\dev\\CC_Logbook\\CC_Logbook\\Excercises\\Error.txt";

    public static void writeError(String text) throws IOException {
        FileWriter fw;

        try {
            fw = new FileWriter(PATH, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(getFormattedDate() + " " + text);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    private static String getFormattedDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = date.format(formatter);

        return formattedDate;
    }
}
