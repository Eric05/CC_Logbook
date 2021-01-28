package museum.persons.visitors;

import museum.Room;
import museum.ThiefObserver;
import museum.persons.Person;

import java.util.ArrayList;
import java.util.List;

public class Thief extends Person {

    public List<ThiefObserver> observers = new ArrayList<>();

    public Thief(String name) {
        super(name);
    }

    public void steal() {
        var arts = this.getActualRoom().getArtworks();
        System.out.println(this.getName() + " steals " + arts.get(0).getName());
    }

    public void attach(ThiefObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void checkIsAlone() {
        if (this.getActualRoom().getPersons().size() == 1) {
            boolean isAlone = true;
            notifyAllObservers(isAlone);
        }
    }

    @Override
    public void changeRoom(List<Room> rooms) {
        super.changeRoom(rooms);
        checkIsAlone();
    }

    private void notifyAllObservers(boolean isAlone) {
        if (isAlone) {
            for (ThiefObserver observer : observers) {
                observer.update();
            }
        }
    }
}

