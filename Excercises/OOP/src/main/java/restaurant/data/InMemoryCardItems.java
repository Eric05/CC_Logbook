package restaurant.data;

import restaurant.CardItem;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCardItems implements ICardItem {
    private final List<CardItem> items;

    public InMemoryCardItems() {
        items = new ArrayList<>();
        items.add(new CardItem("drink", "Cola", 3.2));
        items.add(new CardItem("main", "Burger", 13.2));
        items.add(new CardItem("dessert", "ice", 4.7));
    }

    @Override
    public List<CardItem> getCardItems() {
        return items;

    }
}
