package umlToCode.aggregation;

import umlToCode.composition.Room;

public class Course {
    private String name;
    private Room room;

    public Course(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    @Override
    public String toString() {
        return this.name + "\n" +
                "Ort: " + this.room + "\n";

    }
}

