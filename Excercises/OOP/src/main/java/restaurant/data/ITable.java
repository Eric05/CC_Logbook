package restaurant.data;

import java.sql.SQLException;
import java.util.List;

public interface ITable {
    List<restaurant.Table> getTables() throws SQLException;
}
