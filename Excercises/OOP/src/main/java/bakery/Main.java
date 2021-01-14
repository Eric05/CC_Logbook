package bakery;

import bakery.cookie.Cookie;
import bakery.employee.Baker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static List<Order> productionList = new ArrayList<>();

    public static void main(String[] args) {
        Cookie c1 = new Cookie("ceylon");
        Cookie c2 = new Cookie("vanille");
        var cookies = new ArrayList<>(Arrays.asList(c1, c2));

        Baker b1 = new Baker("tim", 10, 20, "ceylon");
        Baker b2 = new Baker("tom", 10, 20, "vanille");
        Order.bakers = new ArrayList<>(Arrays.asList(b1, b2));

        Customer cu1 = new Customer(1, "Franz");
        Customer cu2 = new Customer(2, "Inge");

        cu1.makeOrder("ceylon", 180);
        cu1.makeOrder("ceylon", 250);
        cu2.makeOrder("vanille", 76);
        cu2.makeOrder("vanille", 56);
        cu1.makeOrder("ceylon", 46);
        cu2.makeOrder("vanille", 66);


        var entries = Order.dailyPlan.entrySet();

        for (var e : entries) {
            System.out.println(e.getValue() + " " + e.getKey() + " are produced");
        }
    }
// TODO delete
//    public static void isProducable(List<Baker> bakers, List<Order> orders, Order newOrder) {
//
//        int free = 0;
//        int needed = 0;
//        List<Order> allOrders = new ArrayList<>(orders);
//
//        allOrders.add(newOrder);
//
//        for (int i = 0; i < allOrders.size(); i++) {
//            var order = allOrders.get(i);
//            for (var baker : bakers) {
//                if (baker.getFavCookie().equals(order.getCookie())) {
//                    var time = (int) Math.ceil(order.getAmount() / baker.getFavPerHour());
//                    if (time < 10) {
//                        free += 10 - time;
//                    } else {
//                        needed += order.getAmount() - baker.getFavPerHour() * 10;
//                    }
//                }
//            }
//        }
//        if (free * 10 > needed) {
//            System.out.println("can be produced");
//            productionList = allOrders;
//
//        } else {
//            System.out.println("can NOT be produced");
//            productionList = orders;
//        }
//    }
//    public static boolean isProducable(List<Baker> bakers, List<Order> orders, int index) {
//
//        int free = 0;
//        int needed = 0;
//
//        for (int i = 0; i < index; i++) {
//            var order = orders.get(i);
//            for (var baker : bakers) {
//                if (baker.getFavCookie().equals(order.getCookie())) {
//                    var time = (int) Math.ceil(order.getAmount() / baker.getFavPerHour());
//                    if (time < 10) {
//                        free += 10 - time;
//                    } else {
//                        needed += order.getAmount() - baker.getFavPerHour() * 10;
//                    }
//                }
//            }
//        }
//        if (free * 10 > needed) {
//
//            return true;
//        }
//        return isProducable(bakers, orders, index - 1);
//    }
}
