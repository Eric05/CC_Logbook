package museum.persons.changeRoomStrategy;

import museum.Room;
import museum.persons.Person;
import museum.persons.changeRoomStrategy.ChangeRoomStrategy;

import java.util.List;
import java.util.Random;

public class ChangeRoomRandomly implements ChangeRoomStrategy {

    @Override
    public Room changeRooms(Person person, List<Room> rooms) {
        Random r = new Random();
        var roomNumber = r.nextInt(rooms.size() - 1) + 1;
        return rooms.get(roomNumber);
    }
}
