package car;

import car.data.InMemoryStationPrices;
import car.data.StationPrices;

import java.util.Map;

public class GasStation {
    private String name;
    private double dailyIncome;
    private Map<String, Double> prices;
    private StationPrices pricesDAO = new InMemoryStationPrices();

    public GasStation(String name) {
        this.name = name;
        this.prices = getPrices();
    }

    public void getCash(Driver driver, String gasType, double amount) {
        var toPay = amount * prices.get(gasType);
        driver.payGas(toPay);
        this.dailyIncome += toPay;
        System.out.println(driver.getName() + " pays " + toPay);
    }

    public Map<String, Double> getPrices() {
        return pricesDAO.getAllPrices();
    }

    public String getName() {
        return name;
    }
}
