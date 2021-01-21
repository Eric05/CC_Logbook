package restaurant;

import java.util.List;

public class Table {
    private boolean isFree = true;
    private int id;
    private int places;
    private Group group;

    public Table(int id, int places) {
        this.id = id;
        this.places = places;
    }

    public void setGroupToTable(Group group){
        this.isFree = false;
        this.group = group;
        group.setTable(this);
    }

    public void freeTable(){
        this.isFree = true;
        this.group = null;
        System.out.println("Group leaves table " + this.id);
    }

    public boolean isFree() {
        return isFree;
    }

    public int getId() {
        return id;
    }

    public int getPlaces() {
        return places;
    }

    public Group getGroup() {
        return group;
    }
}
