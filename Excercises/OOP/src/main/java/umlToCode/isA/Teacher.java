package umlToCode.isA;

public class Teacher extends Person{
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }
}
