package car.data;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStationPrices implements StationPrices{
    @Override
    public Map<String, Double> getAllPrices() {
        Map prices = new HashMap();
        prices.put("Petrol",1.2);
        prices.put("Diesel", 1.12);

        return prices;
    }
}
