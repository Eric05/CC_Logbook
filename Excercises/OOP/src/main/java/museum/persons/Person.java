package museum.persons;

import museum.Room;
import museum.persons.changeRoomStrategy.ChangeRoomContext;
import museum.persons.changeRoomStrategy.ChangeRoomGuard1;
import museum.persons.changeRoomStrategy.ChangeRoomRandomly;
import museum.persons.employees.Guard;

import java.util.List;

public abstract class Person {
    private String name = "";
    private Room actualRoom;

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }

    public void changeRoom(List<Room> rooms) {
        if (actualRoom != null) {
            actualRoom.deletePerson(this);
        }
        actualRoom = getNextRoom(this,rooms);
        actualRoom.addPerson(this);
    }

    public String getName() {
        return name;
    }

    public Room getActualRoom() {
        return actualRoom;
    }

    private Room getNextRoom(Person person, List<Room> rooms){
        ChangeRoomContext cc;
        if (person instanceof Guard && ((Guard) person).getMotivation() == 1) {
            cc = new ChangeRoomContext(new ChangeRoomGuard1());
        } else {
            cc = new ChangeRoomContext(new ChangeRoomRandomly());
        }

        return cc.executeStrategy(person, rooms);
    }
}
