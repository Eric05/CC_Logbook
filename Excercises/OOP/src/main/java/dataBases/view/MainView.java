package dataBases.view;

import car_withDatabase.models.Car;

import java.util.List;
import java.util.Scanner;

public class MainView {
    public void printScreen(){
        System.out.println("Welcome");
        System.out.println("Choose [1] to list cars");
        System.out.println("Choose [2] to search item");
    }
    public void printMessage(String msg){
        System.out.println(msg);
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        return inp;
    }
    public  void  printCars(List<Car> foods){
        for (Car car : foods) {
            System.out.println(car.getBrand()+ " | " +  car.getType() );
        }
    }
}
