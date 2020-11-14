package com.company.November;

import java.util.Scanner;

public class Snake {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static String dir = "d";
    public static boolean isMoving = true;

    public static void getInput() {

        System.out.println("move:");
        Scanner sc = new Scanner(System.in);
        dir = sc.nextLine();
        while (dir == null) {
            isMoving = false;
        }
        System.out.println();

    }

    public static void moveNonstop(char[][] matrix, int row, int col, char ch) throws InterruptedException {

        while (isMoving) {
            Thread.sleep(3000);
            var poses = getPos(matrix);
            row = poses[0];
            col = poses[1];
            matrix[row][col] = '+';
            printField(matrix);
            Thread t2 = new Thread(Snake::getInput);
            t2.start();

            switch (dir) {
                case "u":
                    moveUp(matrix, row, col, ch);
                    break;
                case "d":
                    moveDown(matrix, row, col, ch);
                    break;
                case "l":
                    moveLeft(matrix, row, col, ch);
                    break;
                case "r":
                    moveRight(matrix, row, col, ch);

            }
        }
    }

    public static void move(char[][] matrix, int row, int col, char ch) {

        Scanner sc = new Scanner(System.in);
        var poses = getPos(matrix);
        row = poses[0];
        col = poses[1];
        matrix[row][col] = '+';

        switch (sc.next()) {
            case "u":
                moveUp(matrix, row, col, ch);
                break;
            case "d":
                moveDown(matrix, row, col, ch);
                break;
            case "l":
                moveLeft(matrix, row, col, ch);
                break;
            case "r":
                moveRight(matrix, row, col, ch);
        }
    }

    private static void moveLeft(char[][] matrix, int row, int col, char ch) {
        matrix[row][col - 1] = '+';
    }

    private static void moveRight(char[][] matrix, int row, int col, char ch) {

        matrix[row][col + 1] = '+';
    }

    private static void moveUp(char[][] matrix, int row, int col, char ch) {
        matrix[row - 1][col] = '+';
    }

    private static void moveDown(char[][] matrix, int row, int col, char ch) {
        matrix[row + 1][col] = '+';
    }

    public static int[] getPos(char[][] matrix) {
        int max = matrix.length;
        int[] poses = new int[2];

        for (int row = 0; row < max; row++) {
            for (int col = 0; col < max; col++) {
                if (matrix[row][col] == '+') {
                    poses[0] = row;
                    poses[1] = col;
                }
            }
        }
        return poses;
    }

    public static char[][] initField(int max, char ch) {
        char[][] matrix = new char[max][max];

        for (int row = 0; row < max; row++) {
            for (int col = 0; col < max; col++) {
                matrix[row][col] = ch;
            }
        }
        matrix[0][0] = '+';
        return matrix;
    }

    public static void printField(char[][] field) {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == '+') {
                    System.out.print("" + ANSI_YELLOW_BACKGROUND + " " + field[i][j] + " " + ANSI_RESET);
                } else if (field[i][j] == 2) {
                    System.out.print("" + ANSI_BLUE_BACKGROUND + " " + field[i][j] + " " + ANSI_RESET);
                } else {
                    System.out.print("" + " " + field[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
