package errorHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileHandler {

    public static String readFirstLine(String path) {
          try (Scanner file = new Scanner(new File(path))) {
            if (file.hasNextLine()) return file.nextLine();
        } catch (FileNotFoundException e) {
            // Logging, etc
            System.out.println("error");
        }
        return null;
    }

    public static String readFirstLine_Error(String path) throws IncorrectFileNameException {
        try (Scanner file = new Scanner(new File(path))) {
            if (file.hasNextLine()) {
                return file.nextLine();
            }
        } catch (FileNotFoundException err) {
            if (!Files.exists(Path.of(path))) {
                throw new IncorrectFileNameException(
                        "Incorrect filename : " + path , err);
            }
            // FileExtensionException
/*        } catch(IllegalArgumentException err) {
            if(!containsExtension(fileName)) {
                throw new IncorrectFileExtensionException(
                        "Filename has no extension : " + fileName, err);
            }*/
        }
        return null;
    }
}
