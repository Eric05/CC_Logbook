package restaurant.data;

import restaurant.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTables implements ITable{

    @Override
    public List<Table> getTables() throws SQLException {
        List<Table> tables = new ArrayList<>();
        Connection con;
        PreparedStatement preparedStatement = null;

        try {
        con = MySqlConnector.connect();
            preparedStatement = con.prepareStatement("SELECT * from freeTables");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet resultSet1 = preparedStatement != null ? preparedStatement.executeQuery() : null;

        while (true) {
            assert resultSet1 != null;
            if (!resultSet1.next()) {
                break;
            }
            int id  = resultSet1.getInt("id");
            int places = resultSet1.getInt("places");
            tables.add(new Table(id,places));
        }
        return tables;
    }
}
