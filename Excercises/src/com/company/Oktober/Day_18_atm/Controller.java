package com.company.Oktober.Day_18_atm;

import java.util.Scanner;

public class Controller {

    public void routine(){
        View v = new View();

        v.printWelcomeScreen();
        var pin = v.getPin();

        v.printMenu();
        var menu = v.getMenuInput();
       if (menu == 1) {
           v.printAmount(MoneyOperations.getAmount());

       }

        }


}

