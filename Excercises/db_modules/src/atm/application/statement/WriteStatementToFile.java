package atm.application.statement;

import atm.application.GetConfig;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class WriteStatementToFile {

    private static final String fileOutput = GetConfig.PATH_TO_WORKDIR + File.separator + GetConfig.getProperty(GetConfig.PATH_TO_CONFIG, "file.output");

    public static void write(String res) {
        String path = createFilenameByDate();

        try {
            Files.write(Path.of(path), Collections.singleton(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createFilenameByDate() {
        LocalDateTime date = LocalDateTime.now();
        var cleanDate = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = date.format(cleanDate)+ "_statement";
        return fileOutput + File.separator + formattedDate;
    }

}
