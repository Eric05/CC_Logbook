package human;

import java.util.Comparator;

public class Controller {

    public static void main(String[] args) {
        var man = new Man("a", "b", 12, "xy", "IT", true);

        new Humans(12);
        var listHumans = Humans.humans;
        listHumans.sort(Comparator.comparingInt(Human::getYear));
        listHumans.sort(Comparator.comparing(Human::getFirstName).reversed());
        View.printHuman(man);

        View.printHumanList(listHumans);
    }

}
