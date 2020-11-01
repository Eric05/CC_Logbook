package com.company.Oktober.Holiday;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GuessingGame {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public void play() throws IOException {
        boolean isRunning = true;
        int tries = 7;

        System.out.println("Choose your color: [g]reen\t[b]lue\t[w]hite");
        Scanner sc1 = new Scanner(System.in);
        var color = sc1.nextLine();

        switch (color) {
            case "g":
                System.out.println(ANSI_GREEN);
                break;
            case "b":
                System.out.println(ANSI_BLUE);
                break;
            default:
                break;
        }
        var rankings = getRankings("C:\\dev\\Ranking.txt");
        printRanking(rankings, 5);

        while (isRunning) {
            Instant start = Instant.now();

            var isWinner = playRoutine(tries);

            Instant stop = Instant.now();

            if (isWinner) {
                var duration = Duration.between(start, stop).toMillis();
                var timeSpan = TimeUnit.MILLISECONDS.toMillis(duration);
                Double spanToSeconds = timeSpan / 1000.0;
                Double result = Math.round(spanToSeconds * 100.0) / 100.0;

                writeNewRanking("C:\\dev\\Ranking.txt", String.valueOf(result));
                System.out.println("\t-> Your time was " + result + " seconds.");
            }

            System.out.println("Do you wanna play again? [y]es [n]o");
            Scanner sc = new Scanner(System.in);
            String input = null;
            try {
                input = sc.nextLine();
            } catch (Exception e) {
                System.out.println(ANSI_YELLOW + "please enter valid number..." + ANSI_RESET);
            }

            if (input == null || !input.equals("y")) {
                isRunning = false;
            }
        }
    }

    private boolean playRoutine(int tries) {
        Random random = new Random();
        int randNumber = random.nextInt(50) + 1;
        int guess = 0;
        boolean isValid;
        int tolerance = 0;

        while (tries >= 0) {
            tries--;
            isValid = false;

            if (tries < 0) {
                System.out.print("No more tries. Number was " + randNumber);
                System.out.println();
                return false;
            }
            System.out.println("Make your guess");

            Scanner sc = new Scanner(System.in);
            try {
                guess = sc.nextInt();
                isValid = true;
            } catch (Exception e) {
                if (tolerance < 2) {
                    System.out.println(ANSI_YELLOW + "please enter valid number..." + ANSI_RESET);
                    tolerance++;
                    tries++;
                } else {
                    System.out.println(ANSI_RED + "enough now! Tries [" + tries + "]" + ANSI_RESET);
                }
            }

            if (isValid) {
                if (guess == randNumber) {
                    System.out.println("Well done!");
                    return true;
                } else if (guess > randNumber) {
                    System.out.println("too large. Tries [" + tries + "]");
                } else {
                    System.out.println("too small. Tries [" + tries + "]");
                }
            }
        }
        return false;
    }

    public void printRanking(List<String> rankings, int max) {
        System.out.println("\tLEADERBOARD");

        for (int i = 0; i < max; i++) {
            var line = rankings.get(i).split(",");
            System.out.println( (i+1) + ":\t" + line[1] + "\t| Time: " + line[0]);
        }
        System.out.println();
    }

    public List<String> getRankings(String path) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));

        lines.sort(Comparator.comparing(a -> Double.valueOf(a.split(",")[0])));
        return lines;
    }

    public void writeNewRanking(String path, String time) throws IOException {
        System.out.println("Enter your name");
        Scanner sc = new Scanner(System.in);
        var name = sc.nextLine();
        var ranking = time + "," + name.trim();
        FileWriter fw = new FileWriter(path, true);

        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(ranking);
        bw.newLine();
        bw.close();
    }
}

