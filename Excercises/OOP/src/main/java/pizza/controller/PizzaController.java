package pizza.controller;

import pizza.Ingredient;
import pizza.Pizza;
import pizza.model.InMemoryIngredients;
import pizza.model.InMemoryPizzas;
import pizza.model.IngredientsModel;
import pizza.view.PizzaView;

import java.util.List;
import java.util.stream.Collectors;

public class PizzaController {

    private PizzaView view = new PizzaView();
    private IngredientsModel dao = new InMemoryIngredients();
    private List<Ingredient> ingredients = dao.getIngredients();
    private List<Ingredient> ingredientList;
    private Pizza pizza;
    private int baseIngredientId;

    public PizzaController(int id) {
        new InMemoryPizzas();
        var bases = ingredients.stream().takeWhile(i -> i.getId() <= id).collect(Collectors.toList());
        this.ingredientList = ingredients.stream().skip(id).collect(Collectors.toList());
        this.pizza = InMemoryPizzas.pizzas.get(0);
        this.baseIngredientId = id;
    }

    public void printGreeting() {
        view.printGreeting("Bella Napoli");
    }

    public void choosePizza(int id){
        new InMemoryPizzas();
        this.pizza = InMemoryPizzas.pizzas.get(id);
    }

    public void orderRoutine() {

        while (true) {
            view.printBases(pizza.getName(), pizza.getIngredients());
            view.printIngredients(this.ingredientList);
            var inp = view.getInput();

            if (inp == 0) {
                break;
            }
            if (inp <= baseIngredientId || inp > ingredients.size()) {
                view.printError();
                continue;
            }
            pizza.addIngredient(ingredients.get(inp - 1));
        }
    }

    public Pizza getPizza() {
        return pizza;
    }
}
