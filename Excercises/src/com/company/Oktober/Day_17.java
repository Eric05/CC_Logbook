package com.company.Oktober;

import java.util.Random;
import java.util.regex.Pattern;

/***
 * generate random String
 * rounding
 * walking man
 * validate Integer input
 */
public class Day_17 {

    public static final String GREEN_BOLD = "\033[1;32m";
    private static Random rand = new Random();
    private static String charset = "abcdefghij";

    public static void printRandom() {
        var sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            var len = charset.length();
            var randomChar = charset.charAt(rand.nextInt(len));
            sb.append(randomChar);
        }
        System.out.println(sb.toString());
    }

    public static void roundNums(double number, double factor) {

        float[] values = {1.0f, 1.15f, 1.5f, 1.91f, 11f, 19f, 120f};

        for (float f : values) {
            System.out.print(f + " ");
            System.out.print(Math.round(f) + " "); // Nach .5 Regel
            System.out.print(Math.floor(f) + " "); // Abrunden
            System.out.print(Math.ceil(f));        // Aufrunden
            System.out.println();
        }
        System.out.println("--------------------------");

        float faktor = 0.1f;
        for (float f : values) {
            System.out.print(f + " ");
            System.out.print(faktor * Math.round(f / faktor) + " "); // Nach .5 Regel
            System.out.printf("%.2f ", faktor * Math.floor(f / faktor)); // Abrunden
            System.out.printf("%.2f", faktor * Math.ceil(f / faktor));        // Aufrunden
            System.out.println();
        }
    }

    public static void steps(int len, int probLeft, int probRight, int mood) throws InterruptedException {

        int pos = len / 2;
        int steps = 0;
        boolean isEnd = false;
        probLeft = probLeft + mood;
        probRight = probRight + mood;

        while (!isEnd) {
            steps++;
            isEnd = pos == 0 || pos == len ;

            System.out.println(GREEN_BOLD);
            Thread.sleep(200);

            int direction = rand.nextInt(100) + 1;

            if (direction < probLeft) {
                pos--;
            } else if (direction >= probRight) {
                pos++;
            }
            if (!isEnd) {
                System.out.print("Steps: " + steps + " \tMy Pos now is: " + pos + "\t");
                printGameField(pos, len);
                System.out.println();
            }
        }
        if (pos <= 0) {
            System.out.println("I was too lazy");
        } else {
            System.out.println("Target reached");
        }
    }

    public static void printGameField(int pos, int len) {
        System.out.print("[");
        for (int i = 0; i <= len; i++) {
            if (i == pos) {
                System.out.print("x");
            } else {
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }

    public static boolean isValidInput(String line) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (pattern.matcher(line).matches() && line != null) {
            return true;
        }
        return false;
    }
}

/*DriverCode ...
    int len = 20;
    boolean isValid = false;
    int tries = 5;

        System.out.println("Enter length");
                while (!isValid) {
                tries--;
                if (tries == 0){
                System.out.println();
                System.out.println("are you kidding me !!!!!");
                System.out.println("bye");
                return;
                }
                Scanner sc = new Scanner(System.in);
                var line = sc.nextLine();
                if (isValidInput(line)) {
                len = Integer.valueOf(line);
                isValid = true;
                } else {
                System.out.println(RED + "please enter valid input");
                }
                }
                Day_17.steps(len, 30, 70, -20);
 public static boolean isValidInput(String line) {
    Pattern pattern = Pattern.compile("-?\\d+(\\d+)?");

    if (pattern.matcher(line).matches() && line != null) {
        if (Integer.valueOf(line) > 2 && Integer.valueOf(line) < 100) {
            return true;
        }
    }
    return false;
}

 */