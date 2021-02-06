package kindergarten.animals;

import kindergarten.persons.Child;

public class Dog extends Animal implements IGoToChild {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void goToChild(Child child) {
        System.out.println(" --- " + child.getName() + " hates dog");
        child.setHappiness(child.getHappiness() - 5);
    }
}
