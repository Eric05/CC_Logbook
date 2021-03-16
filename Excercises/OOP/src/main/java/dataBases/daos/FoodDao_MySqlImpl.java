package dataBases.daos;

import dataBases.models.Food;
import dataBases.mySql.MySqlConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao_MySqlImpl implements FoodDao {
    private Connection con;
    private List<Food> foods;

    @Override
    public List<Food> getAllFoods() {
        foods = new ArrayList<>();

        try {
            con = MySqlConnector.connect("jdbc:mysql://localhost:3307/world", "root", "my-secret-pw");
            var preparedStatement = con.prepareStatement("select * from foods");
            var rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");

                foods.add(new Food(name, id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return foods;
    }


}
