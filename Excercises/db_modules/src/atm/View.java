package atm;

import java.util.Scanner;

public class View {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String BLUE = "\033[0;34m";

    public void printWelcomeScreen() {
        System.out.println("Pin please");
    }

    public void printMenu() {
        System.out.println("Please make your choice: \n[1] show amount \n[2] withdraw \n[3] deposit \n[4] exit");
    }

    public void printAmount(double amount) {
        System.out.println("You have " + amount);
    }

    public String getPin() {
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine();
        if (isValidInput(input)) {
            return input;
        }
        return input;
    }

    public int getMenuInput() {
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine();
        if (isValidInput(input)) {
            return Integer.valueOf(input);
        }
        return Integer.valueOf(input);
    }

    public void askForAmount() {
        System.out.println("Enter amount");
    }

    public int getAmount() {
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine();
        if (isValidInput(input)) {
            return Integer.valueOf(input);
        }
        return Integer.valueOf(input);
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printInfo(String msg) {
        System.out.println(BLUE + msg + RESET);
    }

    public void printWarning(String msg) {
        System.out.println(RED + msg + RESET);
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public boolean isValidInput(String string) {
        return true;
    }
}
