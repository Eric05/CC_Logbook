package notes.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector_Singleton {

    private static MySqlConnector_Singleton instance = null;
    private static Connection con = null;

    private MySqlConnector_Singleton() {
    }

    public static MySqlConnector_Singleton getInstance() {
        if (instance == null) {
            instance = new MySqlConnector_Singleton();
        }
        return instance;
    }

    public static Connection connect(String url, String user, String pass) {
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}





