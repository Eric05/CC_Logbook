package car_withDatabase.controller;

import car_withDatabase.daos.CarDao;
import car_withDatabase.daos.CarDao_MySqlImpl;
import car_withDatabase.models.Car;
import car_withDatabase.models.Customer;
import car_withDatabase.view.CarView;
import dataBases.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private CarView view;
    private List<Car> cars = new ArrayList<>();
    private CarDao dao = new CarDao_MySqlImpl();


    public Controller(CarView view) {
        this.view = view;
        this.cars = dao.getAllCars();
    }

    public void doRegistration() {

    }

    public void routine() {
        view.printScreen();
        var inp = view.getInput();
        if (inp.equals("1")) {
            printAllCars();
        } else if (inp.equals("2")) {
            getCar();
        }
    }

    public void printAllCars() {
        view.printCars(cars);
    }

    public void getCar() {
        view.printMessage("Enter car");
        var car = view.getInput();
        var found = cars.stream()
                .filter(c -> c.getBrand().startsWith(car))
                .findFirst().get();
        view.printMessage(found.getBrand());
    }

    public void rentCar(Customer c, int id){
        var mysql = new CarDao_MySqlImpl();
        var car = mysql.getCarById(String.valueOf(id));
        c.orderCar(car);
        mysql.rentCar(id);
    }
}
