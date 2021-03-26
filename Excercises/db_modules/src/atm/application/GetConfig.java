package atm.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetConfig {

    public final static String PATH_TO_WORKDIR = System.getProperty("user.dir");
    public final static String PATH_TO_CONFIG = PATH_TO_WORKDIR + File.separator + "atm.properties";

    public static String getProperty(String path, String prop) {

        try (InputStream input = new FileInputStream(path)) {

            Properties props = new Properties();
            props.load(input);

            return props.getProperty(prop);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
