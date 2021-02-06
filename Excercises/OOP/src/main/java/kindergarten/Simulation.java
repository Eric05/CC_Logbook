package kindergarten;

import kindergarten.persons.Child;

import java.util.*;
import java.util.stream.Collectors;

public class Simulation {

    private final Kindergarten kg;
    private final List<Child> children;

    public Simulation(String name) {
        kg = new Kindergarten(name);
        children = new ArrayList<>(kg.getChildren());
    }

    public void dailyRoutine(int openingTime, int closingTime, int intervalByMinutes) {
        Calendar now = Calendar.getInstance();

        var open = (Calendar) now.clone();
        var close = (Calendar) now.clone();

        open.set(Calendar.HOUR_OF_DAY, openingTime);
        open.set(Calendar.MINUTE, 0);
        close.set(Calendar.HOUR_OF_DAY, closingTime);
        close.set(Calendar.MINUTE, 0);

        while (open.compareTo(close) < 0) {
            open.add(Calendar.MINUTE, intervalByMinutes);

            System.out.println(" ------------------");
            System.out.println(open.getTime());
            delay(2000);
            childrenPlay();
            animalContact();
            takeCare();
            printMood();
            delay(4000);
        }
    }

    private void childrenPlay() {
        List<Child> childrenCopy = new ArrayList<>(children);
        var games = Game.values();
        var gameIndex = 0;

        Collections.shuffle(childrenCopy);

        for (Child child : childrenCopy) {
            child.play(games[gameIndex]);

            gameIndex = (gameIndex < games.length - 1) ? gameIndex : 0;
            gameIndex++;
        }
    }

    private void printMood() {
        for (Child child : kg.getChildren()) {
            System.out.println(child.getName() + "s mood is " + child.getHappiness());
        }
    }

    private void animalContact() {
        var animals = kg.getAnimals();
        var childrenCopy = new ArrayList<>(children);

        Collections.shuffle(childrenCopy);

        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).goToChild(childrenCopy.get(i));
        }

    }

    private void takeCare() {
        var sortedByMood = children.stream()
                .sorted(Comparator.comparing(Child::getHappiness))
                .collect(Collectors.toList());
        if (sortedByMood.get(0).getHappiness() < 10) {
            kg.getAdults().get(0).cares(sortedByMood.get(0));
        }
    }

    private void delay(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ignored) {
        }
    }
}
