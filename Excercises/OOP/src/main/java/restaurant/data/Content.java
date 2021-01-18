package restaurant.data;

import restaurant.CardItem;
import restaurant.Table;

import java.util.List;

public interface Content {
    List<Table> getTables();
    List<CardItem> getCardItems();
}
