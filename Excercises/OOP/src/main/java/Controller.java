import lombok.var;

import java.util.Comparator;

public class Controller {

    public static void main(String[] args) {
        var human = new Human("a", "b", 12, "xy", true);

        new Humans(12);
        var listHumans = Humans.humans;
        listHumans.sort(Comparator.comparingInt(Human::getYear));
        listHumans.sort(Comparator.comparing(Human::isMale).reversed());
        View.printHuman(human);

        View.printHumanList(listHumans);
    }
}
