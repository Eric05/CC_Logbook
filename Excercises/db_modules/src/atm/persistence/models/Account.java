package atm.persistence.models;

public class Account {
    private final String name;
    private final String pin;

    public Account(String name, String password) {
        this.name = name;
        this.pin = password;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }
}
