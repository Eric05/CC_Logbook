package restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final List<Guest>group;
    private Table table;

    public Group(Guest[] guests) {
        group = new ArrayList<>();
        Collections.addAll(group, guests);
    }

    public List<Guest> getGroup() {
        return group;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
