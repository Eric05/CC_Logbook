package pizzeria;

import pizzeria.models.Item;
import pizzeria.models.Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ORM {
    Connection con;

    public ORM() {
        try {
            con = MySqlConnector.connect("jdbc:mysql://localhost:3306/Pizzeria?user=root&password=root&serverTimezone=UTC");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Item getItemById(int id) {
        Item item;
        String name = "";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("SELECT * FROM Item WHERE id=?");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        item = new Item(name);
        return item;
    }

    public Pizza getPizzaById(int id) {
        String name = null;
        List<Item> items = new ArrayList<>();

        try {
            var ps = con.prepareStatement("SELECT * FROM Pizza WHERE id=?");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
            }
            ps = con.prepareStatement("SELECT * FROM PizzaItem WHERE PizzaId=?");
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();

            while (rs.next()) {
                String itemid = rs.getString("ItemId");
                Item item = getItemById(Integer.parseInt(itemid));
                items.add(item);
            }
        } catch (SQLException throwables) {
            return null;
        }
        return new Pizza(name, items);
    }

    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzas = new ArrayList<>();

        try {
            var ps = con.prepareStatement("SELECT * FROM Pizza");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                var id = rs.getString("id");
                var pizza = getPizzaById(Integer.parseInt(id));
                pizzas.add(pizza);
            }
        } catch (SQLException throwable) {
            return null;
        }
        return pizzas;
    }
}
