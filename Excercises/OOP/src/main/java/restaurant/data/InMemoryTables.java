package restaurant.data;

import restaurant.Table;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTables implements ITable {
    private final List<Table> tables;

    public InMemoryTables() {
        tables = new ArrayList<>();
        tables.add(new Table(1, 8));
        tables.add(new Table(2, 4));
    }

    @Override
    public List<Table> getTables() {
        return tables;
    }

}
