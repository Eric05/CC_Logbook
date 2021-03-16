package car_withDatabase.daos;

import car_withDatabase.models.Car;
import car_withDatabase.models.Customer;
import dataBases.mySql.MySqlConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao_MySqlImpl implements CustomerDao {
    private Connection con;
    private CarDao_MySqlImpl dao = new CarDao_MySqlImpl();

    public CustomerDao_MySqlImpl() {
        try {
            con = MySqlConnector.connect("jdbc:mysql://localhost:3307/carFactory", "root", "my-secret-pw");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String name, String pw) {
        Customer customer = null;

        try {
            var ps = con.prepareStatement("SELECT * FROM customer WHERE username=? AND password=?");
            ps.setString(1, name);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                var nam = rs.getString("username");
                var id = rs.getString("rented");
                Car car = dao.getCarById(id);
                customer = new Customer(nam,car);

            }
        } catch (SQLException throwables) {
            return null;
        }
        return customer;
    }

    @Override
    public void registerCustomer(String name, String pw) {
        try {
            var ps = con.prepareStatement("insert into customer values(default,?,?,null)");
            ps.setString(1, name);
            ps.setString(2, pw);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
