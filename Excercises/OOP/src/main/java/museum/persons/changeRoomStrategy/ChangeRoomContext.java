package museum.persons.changeRoomStrategy;

import museum.Room;
import museum.persons.Person;

import java.util.List;

public class ChangeRoomContext {

    private final ChangeRoomStrategy strategy;

    public ChangeRoomContext(ChangeRoomStrategy strategy) {
        this.strategy = strategy;
    }

    public Room executeStrategy(Person person, List<Room> rooms) {
        return strategy.changeRooms(person, rooms);
    }
}
