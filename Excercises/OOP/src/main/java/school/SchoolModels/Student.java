package school.SchoolModels;

public class Student extends AbstractPerson {

    private String email;

    public Student(String name, String adress, String email) {
        super(name, adress);
        this.email = email;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
