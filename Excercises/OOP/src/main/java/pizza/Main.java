package pizza;

import pizza.controller.PizzaController;

public class Main {

    public static void main(String[] args) {
        PizzaController pc = new PizzaController(2);
        pc.choosePizza(0);
        Pizza pizza = pc.getPizza();
        pc.printGreeting();

        // TODO -> loop with return list<pizza> to controller
        var price = 0.0;
        pc.orderRoutine();
        price += pizza.getPrice();
        pc.orderRoutine();
        price += pizza.getPrice();

        // TODO -> to view
        System.out.println("pizza costs " + Math.round(pizza.getPrice() * 10) / 10.0 + " total " + price);

    }
}
