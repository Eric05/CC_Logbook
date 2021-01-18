package restaurant;

import restaurant.data.InMemoryCardItems;
import java.util.List;

public class Simulation {
    public static void simulate() {

        Restaurant italy = new Restaurant("Italy");
        List<CardItem> card = new InMemoryCardItems().getCardItems();

        italy.showFreeTables();

        Guest g1 = new Guest("tim");
        Guest g2 = new Guest("sam");
        Group gr1 = new Group(new Guest[]{g1, g2});

        italy.welcomesGroup(gr1);
        italy.setTableForGroup(gr1);
        italy.showFreeTables();

        Guest g3 = new Guest("tom");
        Guest g4 = new Guest("sandy");
        Group gr2 = new Group(new Guest[]{g3, g4});

        italy.welcomesGroup(gr2);
        italy.setTableForGroup(gr2);
        italy.showFreeTables();

        for (Table table : italy.getTables()) {
            if (!table.isFree()) {
                var group = table.getGroup().getGroup();
                for (Guest guest : group) {
                    guest.makeOrder(card);
                }
            }
        }

        var orders = italy.getOrders();
        italy.produceOrders(orders);
        italy.serveOrders(orders);
        italy.getCash(orders);

        italy.freeTable(gr1.getTable());
        italy.showFreeTables();
    }
}
