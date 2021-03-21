package atm.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector_Timezone {

    private static Connection con;

    public static Connection connect(String db, String user, String pw) throws SQLException {
        try {
            con = DriverManager.getConnection(db, user, pw);
        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        }
        return con;
    }

    public static Connection connect(String conStr) {
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
