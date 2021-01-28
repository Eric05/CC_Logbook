package museum.persons.employees.ChangeRoomStrategy;

import museum.Room;

public class GuardChangeRoom1 implements GuardChangeRoomStrategy {


    public GuardChangeRoom1() {
        super();
    }

    @Override
    public void changeRooms(Room room) {
//super.changeRoom(room);
        System.out.println("----------------");
    }
}
