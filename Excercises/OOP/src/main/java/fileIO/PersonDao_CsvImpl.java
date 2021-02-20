package fileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao_CsvImpl implements PersonDao {

    final String PATH = "C:\\dev\\CC_Logbook\\CC_Logbook\\Excercises\\Persons.txt";

    @Override
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();

        try {
            var personsFromCsv = ReadFromFile.readSmallFileToList(PATH);
            for (String p : personsFromCsv) {
                var id = Integer.parseInt(p.split(";")[0]);
                var name = p.split(";")[1];
                persons.add(new Person(id, name));
            }
        } catch (IOException e) {
            return null;
        }
        return persons;
    }

    @Override
    public void addPerson(String name) {
        try {
            int id = getAllPersons().size() + 1;
            String person = id + ";" + name;
            WriteToFile.appendText(person, PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
