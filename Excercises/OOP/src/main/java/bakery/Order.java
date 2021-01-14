package bakery;

import bakery.employee.Baker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Order {

    private static final int HOURS = 10;
    private static final int AVERAGE = 10;
    public static List<Order> productionList = new ArrayList<>();
    public static List<Baker> bakers = new ArrayList<>();
    public static Map<String, Integer> dailyPlan = new HashMap<>();

    private Customer customer;
    private int amount;
    private String cookie;

    public Order(Customer customer, int amount, String cookie, List<Baker> bakers) {
        this.customer = customer;
        this.bakers = bakers;
        this.amount = amount;
        this.cookie = cookie;

        isProducable(bakers, productionList, this);
    }

    public Order(Customer customer, int amount, String cookie) {
        this.customer = customer;
        this.amount = amount;
        this.cookie = cookie;

        isProducable(bakers, productionList, this);
    }

    public int getAmount() {
        return amount;
    }

    public String getCookie() {
        return cookie;
    }

    public void isProducable(List<Baker> bakers, List<Order> orders, Order newOrder) {

        int free = 0;
        int needed = 0;
        int time = 0;
        int max = 0;
        int amount = 0;
        List<Order> allOrders = new ArrayList<>(orders);
        allOrders.add(newOrder);

        for (var baker : bakers) {
        for (var order : allOrders) {
           amount = order.getAmount();
                max = baker.getFavPerHour() * 10;
                if (baker.getFavCookie().equals(order.getCookie())) {
                    time += time + (int) Math.ceil(order.getAmount() / baker.getFavPerHour());
                } else {
                    continue;
                }
            }
            if (time < HOURS) {
                free += HOURS - time;
            } else {
                needed += amount - max;
            }
        }
        if (free * HOURS > needed / AVERAGE) {
            productionList.clear();
            productionList = allOrders;
            positiveLogic(this);

        } else {
            productionList = orders;
            negativeLogic(this);
        }
    }

    private void negativeLogic(Order order) {

        order.customer.notifyCustomer(order.customer.getName() + "' order can NOT be produced");
    }

    private void positiveLogic(Order order) {
        updateOrderList(order);
        order.customer.notifyCustomer(order.customer.getName() + "' order is in production");
    }

    private void updateOrderList(Order order) {

        dailyPlan.clear();

        for (Order o : productionList) {
            if (!dailyPlan.containsKey(o.getCookie())) {
                dailyPlan.put(o.getCookie(), o.getAmount());
            } else {
                var newAmount = o.getAmount() + dailyPlan.get(o.getCookie());
                dailyPlan.put(o.getCookie(), newAmount);
            }
        }
    }
}
