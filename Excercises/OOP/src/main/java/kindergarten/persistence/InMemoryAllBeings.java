package kindergarten.persistence;

import kindergarten.animals.Animal;
import kindergarten.animals.Cat;
import kindergarten.animals.Dog;
import kindergarten.persons.Adult;
import kindergarten.persons.Child;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAllBeings {
    private final List<Adult> adults;
    private final List<Child> children;
    private final List<Animal> animals;

    public InMemoryAllBeings() {
        adults = new ArrayList<>();
        children = new ArrayList<>();
        animals = new ArrayList<>();

        adults.add(new Adult("Tante"));

        children.add(new Child("Nervig"));
        children.add(new Child("Nett"));
        children.add(new Child("Doof"));
        children.add(new Child("Dick"));

        animals.add(new Dog("Bissig"));
        animals.add(new Cat("Lieb"));

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
