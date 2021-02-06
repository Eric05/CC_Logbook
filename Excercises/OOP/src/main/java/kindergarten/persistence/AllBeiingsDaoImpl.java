package kindergarten.persistence;

import kindergarten.animals.Animal;
import kindergarten.persons.Adult;
import kindergarten.persons.Child;

import java.util.List;

public class AllBeiingsDaoImpl implements AllBeingsDao {

    private final InMemoryAllBeings data = new InMemoryAllBeings();

    @Override
    public List<Adult> getAdults() {
        return data.getAdults();
    }

    @Override
    public List<Child> getChildren() {
        return data.getChildren();
    }

    @Override
    public List<Animal> getAnimals() {
        return data.getAnimals();
    }
}
