package fileIO;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {

        PersonDao dao = new PersonDao_CsvImpl();
        //createPersons(20,dao);

        dao.addPerson("Eric", "the Boss");

        var people = dao.getAllPersons();
        printAllPersons(people);

    }

    public static void printAllPersons(List<Person> people) {
        people.sort(Comparator.comparing(Person::getName).reversed());
        for (Person person : people) {
            System.out.println(person.getId() + " \t| " + person.getName() + " " + person.getLastname());
        }
    }

    public static void createPersons(int max, PersonDao dao) {
        String[] firstname = new String[]{"Ali", "Hari", "Bokhee", "Eric", "Jo"};
        String[] lastname = new String[]{"Schmid", "Muller", "Metzger", "Bäcker", "Yan"};
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < max; i++) {
            String first = firstname[random.nextInt(firstname.length - 1)];
            String last = lastname[random.nextInt(lastname.length - 1)];
            dao.addPerson(first, last);
        }
    }

}
