package restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guest {
    private final String name;
    private final List<String> orders = new ArrayList<>();

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void makeOrder(List<CardItem> card) {
        var drinks = card.stream().filter(t -> t.getTyp().startsWith("d")).collect(Collectors.toList());
        if (isOrder(90)) {
            order(drinks);
        }
        var mains = card.stream().filter(t -> t.getTyp().startsWith("m")).collect(Collectors.toList());
        if (isOrder(60)) {
            order(mains);
        }
        var desserts = card.stream().filter(t -> t.getTyp().startsWith("de")).collect(Collectors.toList());
        if (isOrder(30)) {
            order(desserts);
        }
    }

    private boolean isOrder(int prob) {
        var random = (int) (Math.random() * 101);
        return random < prob;
    }

    private void order(List<CardItem> card) {
        var random = (int) (Math.random() * card.size());
        orders.add(card.get(random).getName());
    }
}
