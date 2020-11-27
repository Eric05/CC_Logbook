import lombok.var;

import java.util.List;

public class View {

    public static void printHuman(Human human) {
        var output = human.getFirstName() + " " + human.getLastName() +
                " " + human.getLocation() + " " + human.getYear() + " " +
                human.isMale();
        System.out.println(output);
    }

    public static void printHumanList(List<Human> humans) {
        for (var h : humans) {
            printHuman(h);
        }
    }
}