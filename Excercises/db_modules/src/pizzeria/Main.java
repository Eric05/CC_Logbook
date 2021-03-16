package pizzeria;

import pizzeria.models.Item;
import pizzeria.models.Pizza;

import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ORM orm = new ORM();
        var pizzas = orm.getAllPizzas();
        printAll(pizzas);
    }

    // simple view
    public static void printAll(List<Pizza> pizzas) {
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.getName().toUpperCase(Locale.ROOT) + ": ");
            System.out.println(printItems(pizza.getItems()));
            System.out.println("-------------");
        }
    }

    private static String printItems(List<Item> items) {
        StringBuilder sb = new StringBuilder();

        for (Item item : items) {
            sb.append(item.getName()).append(", ");
        }
        var res = sb.toString();
        var beautified = res.replaceAll(", $|,$", ".");

        return beautified;
    }
}
