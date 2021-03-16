package car_withDatabase;

import car_withDatabase.controller.Controller;
import car_withDatabase.view.CarView;
import dataBases.view.MainView;
import org.apache.commons.codec.binary.Hex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

Registration re = new Registration();
//re.registerUser("sady", "qwerty");


        printPassword();

        var view = new CarView();
        var controller = new Controller(view);

        controller.routine();
    }

    public static void printPassword(){
        var isValid = false;
        while(!isValid) {

            System.out.println("Enter Username");
            Scanner sc = new Scanner(System.in);
            var user = sc.next();
            System.out.println("Enter Password");
            var pw = sc.next();

            Registration re = new Registration();
            isValid = re.isValid(user, pw);

            if(!isValid){
                System.out.println("wrong user or password");
            }
        }
        System.out.println("welcome");
    }
}
