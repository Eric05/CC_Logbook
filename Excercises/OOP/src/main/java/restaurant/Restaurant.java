package restaurant;

import restaurant.data.Content;
import restaurant.data.InMemoryCardItems;
import restaurant.data.InMemoryTables;

import java.util.*;
import java.util.stream.Collectors;

public class Restaurant {
    private final String name;
    private final List<Table> tables;
    private final List<CardItem> card;

    public Restaurant(String name) {
        this.name = name;
        Content dao = new InMemoryTables();
        this.tables = dao.getTables();
        dao = new InMemoryCardItems();
        this.card = dao.getCardItems();
    }

    public void showFreeTables() {
        var freeTables = tables.stream().filter(Table::isFree).collect(Collectors.toList());
        System.out.println();
        System.out.println("ACTUALLY FREE TABLES: " + freeTables.size());
        System.out.println();
    }

    public void welcomesGroup(Group group) {
        System.out.println("chief greets group");
        for (Guest guest : group.getGroup()) {
            System.out.println(" hello " + guest.getName());
        }
        System.out.println();
    }

    public void setTableForGroup(Group group) {
        List<Table> freeTables = tables.stream().filter(Table::isFree).collect(Collectors.toList());
        freeTables.sort(Comparator.comparingInt(Table::getPlaces));

        for (Table freeTable : freeTables) {
            if (freeTable.getPlaces() >= group.getGroup().size()) {
                freeTable.setGroupToTable(group);
                System.out.println("group is seated on table " + freeTable.getId());
                break;
            } else {
                System.out.println("Sorry no suitable tables");
            }
        }
    }

    public Map<Integer, List<CardItem>> getOrders() {
        Map<Integer, List<CardItem>> orders = new HashMap<>();

        for (Table table : tables) {
            var tableId = table.getId();
            List<String> tableOrders = new ArrayList<>();
            if (!table.isFree()) {
                var group = table.getGroup().getGroup();
                for (Guest guest : group) {
                    tableOrders.addAll(guest.getOrders());
                }
                List<CardItem> orderItems = new ArrayList<>();
                for (String tableOrder : tableOrders) {
                    CardItem crd = card.stream().filter(c -> c.getName().equals(tableOrder)).findFirst().get();
                    orderItems.add(crd);
                }
                orders.put(tableId, orderItems);
            }
        }
        System.out.println("waitress takes orders");
        return orders;
    }

    public void produceOrders(Map<Integer, List<CardItem>> orders) {
        System.out.println("all orders produced");
        System.out.println();
    }

    public void serveOrders(Map<Integer, List<CardItem>> orders) {
        var entries = orders.entrySet();
        for (Map.Entry<Integer, List<CardItem>> entry : entries) {
            System.out.println("waitress goes to table " + entry.getKey());
            for (CardItem cardItem : entry.getValue()) {
                System.out.println(" waitress serves " + cardItem.getName());
            }
        }
        System.out.println();
    }

    public void getCash(Map<Integer, List<CardItem>> orders) {
        var entries = orders.entrySet();
        var priceTotal = 0.0;
        for (Map.Entry<Integer, List<CardItem>> entry : entries) {
            var price = 0.0;
            System.out.println("waitress cashes up on table " + entry.getKey());
            for (CardItem cardItem : entry.getValue()) {
                price += (double) Math.round(cardItem.getPrice() * 10) / 10;
                priceTotal += cardItem.getPrice();
                System.out.println(" guest pays " + cardItem.getPrice());
            }
            System.out.println("waitress gets " + (double) Math.round(price * 10) / 10 + " money from table " + entry.getKey());
        }
        System.out.println();
        System.out.println("restaurant makes a total income of " + (double) Math.round(priceTotal * 10) / 10);
    }

    public void freeTable(Table table) {
        table.freeTable();
    }

    public List<Table> getTables() {
        return tables;
    }
}
