package museum.persons.employees;

import museum.persons.Person;


public class Guard extends Person {

    private final int motivation = 1;

    public Guard(String name) {
        super(name);
    }

    public int getMotivation() {
        return motivation;
    }
}

