package museum.persons.changeRoomStrategy;

import museum.Room;
import museum.persons.Person;

import java.util.List;

public interface ChangeRoomStrategy {
    Room changeRooms(Person person, List<Room> roomsRoom );
}
