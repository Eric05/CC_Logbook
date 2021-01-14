package bakery;

import bakery.employee.Baker;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<Order> orders;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void makeOrder(String cookie, int amount) {
        new Order(this, amount, cookie);
    }

    public String getName() {
        return name;
    }

    public void notifyCustomer(String info){
        System.out.println(info);
    }
}
