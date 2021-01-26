package museum;

public class Artwork {
    private String name;
    private Double value;

    public Artwork(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }
}
