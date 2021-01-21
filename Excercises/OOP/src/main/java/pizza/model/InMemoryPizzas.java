package pizza.model;

import pizza.Ingredient;
import pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPizzas {
    public static List<Pizza> pizzas = new ArrayList<>();

    public InMemoryPizzas() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(1, "dough", 5));
        ingredients.add(new Ingredient(2, "tomato", 2));
        pizzas.add(new Pizza("Speciale", ingredients));
    }
}
