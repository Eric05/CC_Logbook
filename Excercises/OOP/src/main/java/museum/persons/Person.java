package museum.persons;

import museum.Room;

public abstract class Person {
    private final String name;
    private Room actualRoom;

    public Person(String name) {
        this.name = name;
    }

    public void changeRoom(Room room){
        if (actualRoom != null){
            actualRoom.deletePerson(this);
        }
        actualRoom = room;
        room.addPerson(this);
    }

    public String getName() {
        return name;
    }

    public Room getActualRoom() {
        return actualRoom;
    }
}