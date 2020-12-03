package human;

public class Child extends Human{

    private String school;

    public Child(String firstName, String lastName, int year, String location, boolean isHappy, String school) {
        super(firstName, lastName, year, location, isHappy);
        this.school = school;
    }
}
