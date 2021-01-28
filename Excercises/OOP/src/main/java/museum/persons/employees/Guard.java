package museum.persons.employees;

import museum.Room;
import museum.persons.Person;
import museum.persons.employees.ChangeRoomStrategy.GuardChangeRoom1;

public class Guard extends Person {
    public final int ROOM_CHANGE = 4;

    public Guard(String name) {
        super(name);
    }

    @Override
    public void changeRoom(Room room) {
         boolean isMotivated = true;
        if (isMotivated) {
            int visited = 0;
            boolean isCrowded = true;

            while (isCrowded && visited < ROOM_CHANGE) {
                if (this.getActualRoom() != null && this.getActualRoom().getPersons().size() < 3) {
                    isCrowded = false;
                    super.changeRoom(room);
                }
                visited++;
            }
                    super.changeRoom(room);
        }
    }
}
