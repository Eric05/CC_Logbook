package umlToCode.composition;

public class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " in Gebäude ";
    }
}
