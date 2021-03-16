package car_withDatabase.test;

import car_withDatabase.Registration;
import car_withDatabase.controller.Controller;
import car_withDatabase.daos.CarDao;
import car_withDatabase.daos.CarDao_MySqlImpl;
import car_withDatabase.daos.CustomerDao;
import car_withDatabase.daos.CustomerDao_MySqlImpl;
import car_withDatabase.models.Car;
import car_withDatabase.view.CarView;
import dataBases.view.MainView;
import org.apache.commons.codec.binary.Hex;

import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        var view = new CarView();
        CarDao_MySqlImpl dao_car= new CarDao_MySqlImpl();
        CustomerDao dao_cust = new CustomerDao_MySqlImpl();
        Controller controller = new Controller(view);
        var cars = dao_car.getAllCars();

        Car car =  dao_car.getCarById("1");

        var hash = Registration.hashPassword("a");
        String hashedString = Hex.encodeHexString(hash);
        var cust = dao_cust.getCustomer("a", hashedString);

        var availble = cars.stream()
                .filter(c -> c.isAvailable())
                .collect(Collectors.toList());

        controller.rentCar(cust,3);

    }
}
