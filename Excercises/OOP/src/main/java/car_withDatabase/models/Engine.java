package car_withDatabase.models;

public class Engine {
    private int id;
    private String name;
    private String type;
    private int power;

    public Engine(String name, String type, int power) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }
}
