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

    public Simulation(String name, int rooms, int arts, int guards) {
        museum = new Museum(name, rooms, arts);
        addGuards(guards);
        now.set(Calendar.HOUR_OF_DAY, 8);
        now.set(Calendar.MINUTE, 0);
    }

    public void printGreeting() {
        museum.printInfo();
    }

    public void dailyRoutine(int minVisitors, int maxVisitors, int thiefPercent, int interval) {
        printGreeting();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }

        for (int i = 0; i < interval; i++) {
            now.add(Calendar.MINUTE, 15);
            printTime();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }

            var visitors = generateVisitors(minVisitors, maxVisitors, thiefPercent);
            System.out.println("-> new visitors: + " + visitors);

            if (i > 1) {
                var actualVisitors = museum.getAllPersons().size();
                if (minVisitors < actualVisitors) {
                    var leaving = leaveMuseum(minVisitors, actualVisitors);
                    System.out.println("-> visitors leaving: - " + leaving);
                }
            }
            System.out.println("-> visitors in museum: " + (museum.getAllPersons().size() - numOfGuards));

            updateThieves();
            visitRooms();
            printGuards();
            checkLonelyThieves();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private void visitRooms() {
        var allPersons = museum.getAllPersons();
        var rooms = museum.getRooms();
        for (Person visitor : allPersons) {
            var newRoom = generateRandom(1, rooms.size());
            visitor.changeRoom(rooms.get(newRoom));
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

    public void updateThieves() {
        for (Person p : museum.getAllPersons()) {
            if (p instanceof Thief && !thieves.contains(p)) {
               thieves.add((Thief) p);
            }
        }
        for (Thief p : thieves) {
            p.attach(this);
        }
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
            }
        }
    }

    private void printTime() {
        System.out.println("--------------------------------------------");
        System.out.println(now.getTime());
        System.out.println("--------------------------------------------");
    }

    private int generateVisitors(int min, int max, int thiefPercent) {
        var allPersons = generateRandom(min, max);
        var thiefs = allPersons * (double) thiefPercent / 100.0;

        for (int i = 0; i < allPersons; i++) {
            if (i < thiefs) {
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
