package atm.persistence;

import atm.application.GetConfig;
import com.mysql.cj.jdbc.ConnectionImpl;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector_Timezone {

    private static Connection con;
    private static String configPath = System.getProperty("user.dir") + File.separator + "atm.properties";
    private static String conStr = GetConfig.getProperty(configPath, "db.conStr");

    public static Connection connect(String db, String user, String pw) throws SQLException {
        try {
            con = DriverManager.getConnection(db, user, pw);
        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        }
        return con;
    }

    public static Connection connect() {
        try {
            con = DriverManager.getConnection(conStr);
        } catch (SQLException e) {
            try {
                throw new SQLException("Error: " + e.getMessage());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return con;
    }

    public static void closeCon(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
