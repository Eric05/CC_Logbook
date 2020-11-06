package com.company.November;

import java.util.Arrays;
import java.util.Scanner;


// - Print Name Letter in color
// - 4 Gewinnt

public class Day_20 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public static void init() {
        boolean isRunning = true;

        String gameOver = "";
        int[][] field = initField(10);
        printField(field);

        int player = 1;
        while (isRunning) {
            var toggle = nextTurn(field, player);
            var gameOvr = evaluate(field, player);

            if (gameOvr == 1){
                System.out.println("1 wins");
            } else if ( gameOvr == 2){
                System.out.println("2 wins");
            }

            printField(field);

            if (toggle) {
                player = togglePlayer(player);
            }
        }
    }


    public static int[][] initField(int max) {
        var matrix = new int[max][max];

        return matrix;
    }

    public static void printField(int[][] field) {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 1) {
                    System.out.print("\t" + ANSI_YELLOW_BACKGROUND + " " + field[i][j] + " " + ANSI_RESET);
                } else if (field[i][j] == 2) {
                    System.out.print("\t" + ANSI_BLUE_BACKGROUND + " " + field[i][j] + " " + ANSI_RESET);
                } else {
                    System.out.print("\t" + " " + field[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean nextTurn(int[][] field, int player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler " + player + " ist an der Reihe.");

        int row = 0;
        int column = 0;
        boolean fieldNotEmpty = field[row][column] == 0;
        boolean isPossible = true;

        while (fieldNotEmpty && isPossible) {
            row = getUserInput(scanner, "Reihe");
            column = getUserInput(scanner, "Spalte");
            isPossible = row == 9 || field[row + 1][column] != 0;


            if (!fieldNotEmpty || !isPossible) {
                System.err.println("Spielfeld bereits belegt oder ungültiger Zug");
                return false;
            } else {
                fieldNotEmpty = !fieldNotEmpty;
                isPossible = true;
            }
                field[row][column] = getPlayersCharacter(player);
        }
        return isPossible;
    }
    private static void printWinMessage(int player) {
        System.out.println("Spieler " + player + " gewinnt!");
    }

    private static void printField(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            System.out.println(Arrays.toString(field[row]));
        }
    }

    private static int getUserInput(Scanner scanner, String type) {
        int input = 0;


        while ( (input <= 0 || input > 9)) {
            System.out.println("Bitte geben sie die " + type + " an :");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();

            } else {
                scanner.next(); // empty scanner again
            }
        }
        return input;
    }

    private static int getPlayersCharacter(int player) {
        if (player == 1) {
            return 1;
        } else if (player == 2) {
            return 2;
        }
        return 0;
    }

    private static int togglePlayer(int player) {
        if (player == 1) {
            return 2;
        }
        return 1;
    }

    public static int[][] setMove(int row, int col, int[][] field, String player) {

        boolean isPossible = row == 9 || field[row - 1][col] != 0;

        if (!isPossible) {
            System.out.println("please choose valid move");
        }

        int[][] updatedField = new int[field.length][field.length];

        if (player.equals("1")) {
            field[row][col] = 1;
        } else if (player.equals("2")) {
            field[row][col] = 2;
        }
        return updatedField;
    }

    // evaluation method for player 1 "4 Gewinnt"
    public static int evaluate(int[][] matrix, int player) {
        int len = matrix.length;
        int sum1 = 0;
        int sum2 = 0;
        int sum0 = 0;
        String res = "";


        //check horizontal
        for (int row = 0; row < len; row++) {
            sum1 = 0;
            for (int col = 0; col < len; col++) {
                boolean isOut = row >= len || row < 0 || col >= len || col < 0;

                if (!isOut && matrix[row][col] == 1) {
                    sum1++;
                    if (sum1 == 4) {
                        return 1;
                    }
                } else if (!isOut && matrix[row][col] == 4) {
                    sum2++;
                    if (sum2 == 4) {
                        return 2;
                    }
                } else {
                    sum0++;
                    sum1 = 0;
                    sum2 = 0;
                }
            }
        }

        // check vertical
        for (int col = 0; col < len; col++) {
            sum1 = 0;
            for (int row = 0; row < len; row++) {
                boolean isOut = row >= len || row < 0 || col >= len || col < 0;

                if (!isOut && matrix[row][col] == 1) {
                    sum1++;

                    if (sum1 == 4) {
                        return 1;
                    }
                } else {
                    sum1 = 0;
                }
            }
        }

        // check diagonal downright
        for (int col = 0; col < len; col++) {
            sum1 = 0;
            for (int row = 0; row < len; row++) {
                boolean isOut = row >= len || row < 0 || col >= len || col < 0;
                if (!isOut && matrix[row][col] == 1) {
                    sum1++;
                    col++;
                    row++;
                    if (sum1 == 4) {
                        return 1;
                    }
                } else {
                    sum1 = 0;
                }
            }
        }

        // check diagonal downleft
        for (int col = 0; col < len; col++) {
            sum1 = 0;
            for (int row = 0; row < len; row++) {
                boolean isOut = row >= len || row < 0 || col >= len || col < 0;
                if (!isOut && matrix[row][col] == 1) {
                    sum1++;
                    col++;
                    row--;
                    if (sum1 == 4) {
                        return 1;
                    }
                } else {
                    sum1 = 0;
                }
            }
        }
        return 0;
    }
}


