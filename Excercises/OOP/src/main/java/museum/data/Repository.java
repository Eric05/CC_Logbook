package museum.data;

import museum.Room;
import museum.persons.employees.Guard;

import java.util.List;

public interface Repository {
    List<Room> getRooms(int max);
    List<Guard> getGuards(int max);
   }
