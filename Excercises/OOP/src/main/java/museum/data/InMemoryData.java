package museum.data;

import museum.Room;
import museum.persons.employees.Guard;

import java.util.ArrayList;
import java.util.List;

public class InMemoryData implements Repository {

    @Override
    public List<Room> getRooms(int max) {
        List<Room> rooms = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            Room room = new Room(i);
            rooms.add(room);
        }
        return rooms;
    }

    @Override
    public List<Guard> getGuards(int max) {
        List<Guard> guards = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            Guard guard = new Guard("guard_" + i);
            guards.add(guard);
        }
        return guards;
    }

}
