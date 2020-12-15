package umlToCode.composition;

import java.util.List;

/**
 * Composition ( uml -> filled diamond)
 * -> strong association
 * -> room is a part of building
 * -> room can not exist without building
 */

public class Building {
    private String name;
    private final List<Room> rooms;

    // Constructor takes rooms as parameter. So if building is destroyed all rooms in that building
    // are destroyed too. (room is contained in building)

    public Building(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return name;
    }
}
