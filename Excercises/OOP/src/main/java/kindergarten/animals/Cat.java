package kindergarten.animals;

import kindergarten.persons.Child;

public class Cat extends Animal implements IGoToChild {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void goToChild(Child child) {
        System.out.println(" ++ " + child.getName() + " hugs cat");
        child.setHappiness(child.getHappiness() + 2);
    }
}
