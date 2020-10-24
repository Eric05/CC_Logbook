package com.company.Oktober;

import java.util.Random;

public class Day_16_Loop {

    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String WHITE = "\033[0;37m";

    public static void printSimulation(int max, int speed) throws InterruptedException {
        System.out.print(GREEN_BOLD);

        for (int i = 0; i < max; i++) {
            Thread.sleep(speed);
            System.out.print(randomNumbers(10, 30, 15, 25) + "\t");
        }
        System.out.println(WHITE);
    }

    public static double calculateAverage(int max) {
        double sum = 0;

        for (int i = 0; i < max; i++) {
            var rand = randomNumbers(10, 30, 15, 25);
            sum += rand;
        }
        return sum / max;
    }

    private static long randomNumbers(int min, int max, int... breakConditions) {
        long sum = 0;
        boolean isRunning = true;

        while (isRunning) {
            int rand = getRandomNumber(min, max);

            for (var b : breakConditions) {
                if (rand % b == 0) {
                    isRunning = false;
                    break;
                }
                sum += rand;
            }
        }
        return sum;
    }

    private static int getRandomNumber(int min, int max) {
        var rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
