package car;

public class Car {
    final double TANK_WARNING = 0.2;
    private String name;
    private int fullTank;
    private int tankLevel;
    private double consumptionPer100Km;

    public Car(String name, int fullTank, int tankLevel, double consumptionPer100Km) {
        this.name = name;
        this.fullTank = fullTank;
        this.tankLevel = tankLevel;
        this.consumptionPer100Km = consumptionPer100Km;
    }

    public void drive(int km) {
        int level;

        for (int i = 0; i < km; i += consumptionPer100Km) {
            level = (int) consumeGas(this.tankLevel, (int) consumptionPer100Km);

            if (level < fullTank * TANK_WARNING) {
                showWarning();
            }

            System.out.println(i + " km driven");
            showTankLevel(level);
            setTankLevel(level);

            if (level <= 0){
                System.out.println("no more fuel");
                return;
            }
        }
    }

    private double consumeGas(int tankLevel, int km) {
        return tankLevel - km / consumptionPer100Km;
    }

    public void showTankLevel(int level) {
        System.out.println("tank level is: " + level);
    }

    private void showWarning() {
        System.out.println("low fuel!!!");
    }

    public int getFullTank() {
        return fullTank;
    }

    public int getTankLevel() {
        return this.tankLevel;
    }

    public void setTankLevel(int tankLevel) {
        this.tankLevel = tankLevel;
    }
}
