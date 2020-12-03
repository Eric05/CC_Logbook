package human;

public class Adult extends Human{

private String job;

    public Adult(String firstName, String lastName, int year, String location, boolean isHappy, String Job) {
        super(firstName, lastName, year, location, isHappy);
        this.job = job;
    }
}

