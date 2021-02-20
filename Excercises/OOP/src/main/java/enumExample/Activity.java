package enumExample;

// enum with int code
public enum Activity {
    SLEEP(100),
    SHOWER(101),
    EAT(102),
    WORK(103),
    LEARN(104),
    PRY(200);

    private final int code;
    Activity(int code) {this.code = code;}
    public int getValue() { return code;}
}
