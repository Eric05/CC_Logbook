package human;

public class Man extends Adult {

    boolean payAlimoy;

    public Man(String firstName, String lastName, int year, String location, String Job, boolean payAlimoy) {
        super(firstName, lastName, year, location, true, "IT");
        this.payAlimoy = payAlimoy;
    }
}
