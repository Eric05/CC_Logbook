package pizza.view;

import pizza.Ingredient;

import java.util.List;
import java.util.Scanner;

public class PizzaView {

    public void printGreeting(String name ) {
        System.out.println("Welcome to our pizzeria " + name);
        System.out.println();
    }

    public void printIngredients(List<Ingredient> ingredients) {
        System.out.println(" you can add:");
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getId() + ": " + ingredient.getName() + " " + ingredient.getPrice());
        }
    }

    public void printBases(String name, List<Ingredient> bases) {
        System.out.println(" pizza " + name + " contains");
        for (Ingredient ingredient : bases) {
            System.out.println(ingredient.getId() + ": " + ingredient.getName() + " " + ingredient.getPrice());
        }
        System.out.println();
    }

    public int getInput() {
        System.out.println(" -> add ingredient or press '0' to order");
        try {
            Scanner sc = new Scanner(System.in); // Create a Scanner object
            return sc.nextInt();
        } catch (Exception ignored) {
        }
        return -1;
    }

    public void printError() {
        System.out.println(" !!!  -------------------- no valid order --------------------- !!! ");
    }

}
