package school.SchoolModels;

public class Teacher extends AbstractPerson {

    private String password;

    public Teacher(String name, String adress, String password) {
        super(name, adress);
        this.password = password;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getAdress() {
        return super.getAdress();
    }

    public void setAdress(String name) {
        super.setAdress(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + super.getName() + '\'' +
                "adress=" + super.getAdress() +
                ", password='" + password + '\'' +
                '}';
    }
}
