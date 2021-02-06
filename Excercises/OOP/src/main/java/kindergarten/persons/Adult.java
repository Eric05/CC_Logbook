package kindergarten.persons;

public class Adult extends Person {

    public Adult(String name) {
        super(name);
    }

    public void cares(Child child) {
        System.out.println(" ++ " + child.getName() + " is comforted");
        child.setHappiness(child.getHappiness() + 2);
    }
}
