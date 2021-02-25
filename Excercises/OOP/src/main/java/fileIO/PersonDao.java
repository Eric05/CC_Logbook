package fileIO;

import java.util.List;

public interface PersonDao {
    List<Person> getAllPersons();

    void addPerson(String name, String lastname);
}
