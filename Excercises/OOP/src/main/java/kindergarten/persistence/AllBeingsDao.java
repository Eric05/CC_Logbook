package kindergarten.persistence;

import kindergarten.animals.Animal;
import kindergarten.persons.Adult;
import kindergarten.persons.Child;

import java.util.List;

public interface AllBeingsDao {

    List<Adult> getAdults();

    List<Child> getChildren();

    List<Animal> getAnimals();

}
