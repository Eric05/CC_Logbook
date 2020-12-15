package designPatterns;

import designPatterns.observer.BinaryObserver;
import designPatterns.observer.HexaObserver;
import designPatterns.observer.Subject;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}

