package designPatterns.observer_Progress;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private Observer observer;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        observer = this.getObserver();
        notifyObserver(observer);
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void notifyObserver(Observer observer) {
        observer.update();
    }
}


