package car;

public class Main {
    public static void main(String[] args) {

        GasStation station = new GasStation("Shell");
        Car skoda = new Car("Skoda", 50, 25, 10.0 );
        Driver d1 = new Driver("sam",skoda);

        skoda.showTankLevel(skoda.getTankLevel());
        d1.drive(220);
        skoda.showTankLevel(skoda.getTankLevel());
        d1.fillGas(station, 20);
        station.getCash(d1, "Petrol",20);
        skoda.showTankLevel(skoda.getTankLevel());

    }
}
