package fileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void appendText(String text, String des) throws IOException {
        FileWriter fw;

        try {
            fw = new FileWriter(des, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(text);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            ErrorLogger.getInstance();
            ErrorLogger.writeError("Error when writing to File");
        }
    }
}
