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

            assert personsFromCsv != null;
            for (String p : personsFromCsv) {
                var fields = parseCsvLine(p, ";");
                persons.add(new Person((Integer) fields[0], (String) fields[1], (String) fields[2]));
            }
        } catch (IOException e) {
            return null;
        }
        return persons;
    }

    private Object[] parseCsvLine(String line, String delim) {
        var clearLine = line.replaceAll(";\\s{1,}", ";")
                .replaceAll("(\\s{1,})", " ")
                .trim();

        Object[] objs = new Object[3];
        var id = Integer.parseInt(clearLine.split(";")[0]);
        var name = clearLine.split(delim)[1];
        String lastname;
        try {
            lastname = clearLine.split(delim)[2];
        } catch (Exception e) {
            lastname = "Muller";
        }
        objs[0] = id;
        objs[1] = name;
        objs[2] = lastname;

        return objs;
    }

    @Override
    public void addPerson(String name, String lastname) {
        try {
            int id = getAllPersons().size() + 1;
            String person = id + ";" + name + ";" + lastname;
            WriteToFile.appendText(person, PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
