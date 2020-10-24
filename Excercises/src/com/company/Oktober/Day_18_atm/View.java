package com.company.Oktober.Day_18_atm;

import java.util.Scanner;

public class View {

    public void  printWelcomeScreen(){
        System.out.println("Card please");
    }

    public void printMenu(){
        System.out.println("Please make your choice\n[1] show amount \n[2] withdraw \n[3] deposit");
    }

    public void printAmount( double amount){
        System.out.println("You have " + amount);
    }

    public int getPin(){
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine();
        if (isValidInput(input)) {
            return Integer.valueOf(input);
        }
        return Integer.valueOf(input);
    }

    public int getMenuInput(){
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine();
        if (isValidInput(input)) {
            return Integer.valueOf(input);
        }
        return Integer.valueOf(input);
    }

    public void askForAmount(){
        System.out.println("Enter amount");
    }

    public int getAmount(){
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine();
        if (isValidInput(input)) {
            return Integer.valueOf(input);
        }
        return Integer.valueOf(input);
    }

    public boolean isValidInput(String string){
        return true;
    }
}
