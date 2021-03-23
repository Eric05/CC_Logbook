package atm.application.statement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class WriteStatementToFile {

    private static final Path workingDir = Path.of(System.getProperty("user.dir"));

    public static void write(String res) {
        LocalDateTime date = LocalDateTime.now();
        var cleanDate = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        String formattedDate = date.format(cleanDate);
        var path = workingDir + File.separator + formattedDate;

        try {
            Files.write(Path.of(path), Collections.singleton(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
