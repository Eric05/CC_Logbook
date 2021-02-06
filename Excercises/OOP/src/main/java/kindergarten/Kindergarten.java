package kindergarten;

import kindergarten.animals.Animal;
import kindergarten.persistence.AllBeiingsDaoImpl;
import kindergarten.persistence.AllBeingsDao;
import kindergarten.persons.Adult;
import kindergarten.persons.Child;

import java.util.ArrayList;
import java.util.List;

public class Kindergarten {
    private final String name;
    private final AllBeingsDao dao = new AllBeiingsDaoImpl();
    private List<Adult> adults;
    private List<Child> children;
    private List<Animal> animals;

    public Kindergarten(String name) {
        this.name = name;
        initGarden();
    }

    private void initGarden() {
        this.adults = new ArrayList<>(dao.getAdults());
        this.children = new ArrayList<>(dao.getChildren());
        this.animals = new ArrayList<>(dao.getAnimals());
    }

    public String getName() {
        return name;
    }

    public List<Adult> getAdults() {
        return adults;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
