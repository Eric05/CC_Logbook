package car_withDatabase.models;

public class Car {
    private int id;
    private String brand;
    private String type;
    private boolean isAvailable;

    public Car(Integer id, String brand, String type, boolean isAvailable) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.isAvailable =isAvailable;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getId(){
        return id;
    }
}
