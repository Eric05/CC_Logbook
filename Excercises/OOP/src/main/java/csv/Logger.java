package csv;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance;

    private Logger() {

    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public static void log(LogType error, String msg) {
        try {
            FileWriter fw = new FileWriter(String.valueOf((Config.LOG_PATH)), true);
            fw.append(error + msg + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // type as inner class
    public enum LogType {
        ERROR, INFO, WARNING
    }
}
