package pizza.model;

import pizza.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class InMemoryIngredients implements IngredientsModel {
    private final List<Ingredient> ingredients = new ArrayList<>();

    public InMemoryIngredients(){
        ingredients.add(new Ingredient(1,"dough",5));
        ingredients.add(new Ingredient(2,"tomato",2));
        ingredients.add(new Ingredient(3,"pep",0.2));
        ingredients.add(new Ingredient(4,"cheese",0.4));
        ingredients.add(new Ingredient(5,"olive",0.5));
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
