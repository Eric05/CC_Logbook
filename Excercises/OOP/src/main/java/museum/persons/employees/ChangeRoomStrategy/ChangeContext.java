package museum.persons.employees.ChangeRoomStrategy;

import museum.Room;
import museum.persons.employees.Guard;

public class ChangeContext {
    private GuardChangeRoomStrategy strategy;

    public ChangeContext(GuardChangeRoomStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Room room){
        strategy.changeRooms(room);
    }
}
