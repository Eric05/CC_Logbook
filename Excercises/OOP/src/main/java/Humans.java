import lombok.var;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Humans {

    public static List<Human> humans;
    private Random r = new Random();

    public Humans(int max) {
        humans = createHumanList(max);
    }

    private List<Human> createHumanList(int max) {
        List<Human> list = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            var first = createRandomName(5);
            var last = createRandomName(7);
            var year = createRandomYear();
            var location = createRandomLocation(10);
            var male = createRandomMale();

            list.add(new Human(first, last, year, location, male));
        }
        return list;
    }

    private String createRandomName(int max) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            var ch = r.nextInt(20) + 65;
            StringBuilder append = sb.append(new Character((char) ch).toString());
        }
        return sb.toString();
    }

    private String createRandomLocation(int max) {
        int half = max / 2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < max; i++) {
            if (i == half) {
                sb.append(" ");
            }
            var ch = r.nextInt(20) + 65;
            StringBuilder append = sb.append(new Character((char) ch).toString());
        }
        return sb.append(" 7").toString();
    }

    private int createRandomYear() {

        int year = r.nextInt(30) + 1970;

        return year;
    }

    private boolean createRandomMale() {
        int bol = r.nextInt(2);
        return bol >= 1;
    }


}
