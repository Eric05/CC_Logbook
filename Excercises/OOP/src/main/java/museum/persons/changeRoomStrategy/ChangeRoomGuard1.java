package museum.persons.changeRoomStrategy;

import museum.Room;
import museum.persons.Person;

import java.util.List;
import java.util.Random;

public class ChangeRoomGuard1 implements ChangeRoomStrategy {

    @Override
    public Room changeRooms(Person person, List<Room> rooms) {
        Random r = new Random();
        int visited = 0;
        boolean isCrowded = true;

        while (isCrowded && visited < rooms.size()) {
            var roomNumber = r.nextInt(rooms.size() - 1) + 1;
            if (rooms.get(roomNumber).getPersons().size() < 3) {
                isCrowded = false;
                return rooms.get(roomNumber);
            }
            visited++;
        }
        return rooms.get(r.nextInt(rooms.size() - 1) + 1);
    }
}

