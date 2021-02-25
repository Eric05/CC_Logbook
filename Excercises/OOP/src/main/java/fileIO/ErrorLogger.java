package fileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorLogger {

    private final static String PATH = "C:\\dev\\CC_Logbook\\CC_Logbook\\Excercises\\Error.txt";
    private static ErrorLogger instance;

    private ErrorLogger() {

    }

    public static ErrorLogger getInstance() {
        if (instance == null) {
            instance = new ErrorLogger();
        }
        return instance;
    }

    public static void writeError(String text) throws IOException {
        FileWriter fw = null;

        try {
            fw = new FileWriter(PATH, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(getFormattedDate() + " " + text);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.err.println("error closing writer for file " + PATH);
                }
            }
        }
    }

    private static String getFormattedDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return date.format(formatter);
    }
}
