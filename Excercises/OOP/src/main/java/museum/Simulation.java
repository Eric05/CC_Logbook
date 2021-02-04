package museum;

import museum.persons.Person;
import museum.persons.employees.Guard;
import museum.persons.visitors.Thief;
import museum.persons.visitors.Visitor;

import java.util.*;
import java.util.stream.Collectors;

public class Simulation extends ThiefObserver {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";

    public static Calendar now = Calendar.getInstance();

    public static int numOfVisitors = 0;
    public static int numOfThieves = 0;
    public static int numOfGuards = 3;

    private final Museum museum;
    private final List<Thief> thieves = new ArrayList<>();
    private final Calendar open;
    private final Calendar close;

    public Simulation(String name, int rooms, int arts, int guards, int openTime, int closeTime) {
        museum = new Museum(name, rooms, arts);
        addGuards(guards);

        open = (Calendar) now.clone();
        close = (Calendar) now.clone();

        open.set(Calendar.HOUR_OF_DAY, openTime);
        open.set(Calendar.MINUTE, 0);
        close.set(Calendar.HOUR_OF_DAY, closeTime);
        close.set(Calendar.MINUTE, 0);
    }

    public void printGreeting() {
        museum.printInfo();
    }

    public void dailyRoutine(int minVisitors, int maxVisitors, int thiefPercent, int interval) {
        printGreeting();
        sleep(5000);

        while (open.compareTo(close) < 0) {
            open.add(Calendar.MINUTE, interval);
            printTime();
            sleep(1000);

            var visitors = generateVisitors(minVisitors, maxVisitors, thiefPercent);
            System.out.println("-> new visitors: + " + visitors);

            if (numOfVisitors > 1) {
                var actualVisitors = museum.getAllPersons().size();
                if (minVisitors < actualVisitors) {
                    var leaving = leaveMuseum(minVisitors, actualVisitors);
                    System.out.println("-> visitors leaving: - " + leaving);
                }
            }
            System.out.println("-> visitors in museum: " + (museum.getAllPersons().size() - numOfGuards));

            initOrUpdateThieves();
            visitRooms();
            printGuards();
            checkLonelyThieves();
            sleep(3000);
        }
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ignored) {
        }
    }

    public void initOrUpdateThieves() {
        for (Person p : museum.getAllPersons()) {
            if (p instanceof Thief && !thieves.contains(p)) {
                thieves.add((Thief) p);
            }
        }
        for (Thief p : thieves) {
            p.attach(this);
        }
    }

    private void visitRooms() {
        var allPersons = museum.getAllPersons();
        var rooms = museum.getRooms();
        for (Person visitor : allPersons) {
            visitor.changeRoom(rooms);
        }
    }

    private void printGuards() {
        var guards = museum.getAllPersons().stream()
                .filter(p -> p instanceof Guard)
                .collect(Collectors.toList());
        System.out.print(" Guards in room: ");
        for (Person guard : guards) {
            System.out.print(guard.getActualRoom().getNumber() + " ");
        }
        System.out.println();
    }

    private void checkLonelyThieves() {
        var rooms = museum.getRooms();

        for (Room room : rooms) {
            var thieves = room.getPersons().stream()
                    .filter(t -> t instanceof Thief)
                    .collect(Collectors.toList());

            if (thieves.size() == 1 && room.getPersons().size() == 1) {
                Thief t = (Thief) thieves.get(0);
                System.out.println(RED + t.getName() + " alone in " + room.getNumber() + RESET);
                t.steal();
                thieves.remove(t);
                museum.getAllPersons().remove(t);
            }
        }
    }

    private void printTime() {
        System.out.println("--------------------------------------------");
        System.out.println(open.getTime());
        System.out.println("--------------------------------------------");
    }

    private int generateVisitors(int min, int max, int thiefPercent) {
        var allPersons = generateRandom(min, max);
        var thieves = allPersons * (double) thiefPercent / 100.0;

        for (int i = 0; i < allPersons; i++) {
            if (i < thieves) {
                numOfThieves++;
                Thief t = new Thief("thief_" + numOfThieves);
                museum.getAllPersons().add(t);
            } else {
                numOfVisitors++;
                Visitor v = new Visitor("visitor_" + numOfVisitors);
                museum.getAllPersons().add(v);
            }
        }
        Collections.shuffle(museum.getAllPersons());
        return allPersons;
    }

    private int generateRandom(int min, int max) {
        var r = new Random();

        return r.nextInt(max - min) + min;
    }

    private int leaveMuseum(int min, int max) {
        var tired = generateRandom(min, max);
        tired = (tired >= museum.getAllPersons().size() - numOfGuards - min) ? min : tired;

        for (int i = tired; i > 0; i--) {
            if (!(museum.getAllPersons().get(i) instanceof Guard)) {
                museum.getAllPersons().remove(i);
            }
        }
        return tired;
    }

    private void addGuards(int max) {
        var allPersons = museum.getAllPersons();
        for (int i = 0; i < max; i++) {
            Guard g = new Guard("guard");
            allPersons.add(g);
        }
    }

    @Override
    public void update() {
        System.out.println(" >>>>> thief gets the chance to steal ");
    }
}
