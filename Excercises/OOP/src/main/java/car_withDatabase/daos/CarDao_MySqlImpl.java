package car_withDatabase.daos;

import car_withDatabase.models.Car;
import car_withDatabase.models.Customer;
import dataBases.mySql.MySqlConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao_MySqlImpl implements CarDao {
    private Connection con;

    public CarDao_MySqlImpl() {
        try {
            con = MySqlConnector.connect("jdbc:mysql://localhost:3307/carFactory", "root", "my-secret-pw");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();

        try {
            var preparedStatement = con.prepareStatement("select * from car");
            var rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = Integer.valueOf(rs.getString("id"));
                String type = rs.getString("type");
                String name = rs.getString("brand");
                Boolean avail = rs.getBoolean("isAvailable");

                cars.add(new Car(id,name,type, avail));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cars;
    }

    public Car getCarById(String idx) {
        Car car = null;

        try {
            var ps = con.prepareStatement("SELECT * FROM car WHERE id=?");
            ps.setString(1,idx);

                      ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                   Integer id = Integer.valueOf(rs.getString("id"));
                    String type = rs.getString("type");
                    String name = rs.getString("brand");
                Boolean avail = rs.getBoolean("isAvailable");

                    car =  new Car(id,name,type,avail);
                }

        } catch (SQLException throwables) {
            return null;
        }
        return car;
    }

    public void rentCar(int id) {
        try {
            var ps = con.prepareStatement("update car set isAvailable = 0 where id = ?");
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
