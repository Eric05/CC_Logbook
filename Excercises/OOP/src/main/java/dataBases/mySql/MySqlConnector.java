package dataBases.mySql;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
    private static java.sql.Connection con;

    public static java.sql.Connection connect(String db, String user, String pw) throws SQLException {
        try {
            con = DriverManager.getConnection(db, user, pw);
        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        }
        return con;
    }
}
