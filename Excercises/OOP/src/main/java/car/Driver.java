package car;

public class Driver {
    private String name;
    private Car car;
    private double money;

    public Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public void drive(int km) {
        car.drive(km);
    }

    public void fillGas(GasStation station, int amount) {
        System.out.println(this.getName() + " goes to " + station.getName());
        this.car.setTankLevel(this.car.getTankLevel() + amount);
    }

    public void payGas( double amount){
        this.money = money - amount;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }
}
