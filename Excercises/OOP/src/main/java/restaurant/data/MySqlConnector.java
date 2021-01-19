package restaurant.data;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {

    public static java.sql.Connection connect() throws SQLException {
        java.sql.Connection connect;
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3308/restaurant?"
                            + "user=root&password=my-secret-pw");
        } catch (
                SQLException throwables) {
            throw new SQLException();
        }
        return connect;
    }
}
