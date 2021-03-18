package notes.view;

import notes.application.UserService;
import notes.persistence.models.Note;
import notes.persistence.models.User;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String BLUE = "\033[0;34m";

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
}
