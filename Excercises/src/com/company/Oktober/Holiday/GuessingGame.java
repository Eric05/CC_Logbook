package com.company.Oktober.Holiday;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public void play() {

        Random random = new Random();
        int randNumber = random.nextInt(50) + 1;
        int tries = 5;
        boolean isRunning = true;

        while (isRunning) {
            tries--;

            if (tries == 0) {
                System.out.print("No more tries. Number was " + randNumber);
                break;
            }

            System.out.println("Make your guess");
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();

            if (guess == randNumber) {
                System.out.println("Well done");
                break;
            } else if (guess > randNumber) {
                System.out.println("too large");
            } else {
                System.out.println("too small");
            }
        }
        Scanner sc1 = new Scanner(System.in);
        var inp = sc1.nextLine();
    }
}
