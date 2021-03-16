package car_withDatabase.view;

import car_withDatabase.models.Car;

import java.util.List;
import java.util.Scanner;

public class CarView {
    public void printScreen(){
        System.out.println("Welcome");
        System.out.println("Choose [1] to list available cars");
        System.out.println("Choose [2] to search for car");
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        var inp = sc.next();
        return inp;
    }

    public static void  printCars(List<Car> cars){

        for (Car car : cars) {
            var avail = car.isAvailable() ? "available"  : "not available";
            System.out.println(car.getId() + ": " +car.getBrand()+ " | " +  car.getType() + " -> " + avail);
        }
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
