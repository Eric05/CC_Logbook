package pizzeria.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final String name;
    private List<Item> items = new ArrayList<>();

    public Pizza(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }
}
