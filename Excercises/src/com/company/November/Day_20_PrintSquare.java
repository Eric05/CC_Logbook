package com.company.November;

public class Day_20_PrintSquare {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public static char[][] matrix = new char[10][10];

    // Print Letter of Name in square
    public static int[][] initField(int max) {
        var matrix = new int[max][max];

        return matrix;
    }

    public static char[][] initField(int max, char ch) {
        char[][] matrix = new char[max][max];

        for (int row = 0; row < max; row++) {
            for (int col = 0; col < max; col++) {
                matrix[row][col] = ch;
            }
        }
        return matrix;
    }

    public static void printInnerSquare() {
        matrix = initField(10, 'o');
        drawHorizontalLine(matrix, 2, 3, 5, '1');
        drawVerticalLine(matrix, 4, 4, 5, '1');
        print2D(matrix);

    }

    public static void print2D(char[][] chars) {
        int len = chars.length;

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                System.out.print("\t" + chars[row][col]);
            }
            System.out.println();
        }
    }

    public static void drawHorizontalLine(char[][] matrix, int rowPos, int colPos, int len, char ch) {
        len = len + colPos;

        for (int i = colPos; i < len; i++) {
            matrix[rowPos][i] = ch;
        }
    }

    public static void drawVerticalLine(char[][] matrix, int rowPos, int colPos, int len, char ch) {
        len = len + rowPos;

        for (int i = rowPos; i < len; i++) {
            matrix[i][colPos] = ch;
        }
    }

    public static void drawVector(char[][] matrix, int startRow, int endRow, int startCol, int endCol, char ch ){


        for (int row = startRow; row < endRow; row++) {
            for (int col = startCol; col < endCol; col++) {
                boolean isOut = row >= matrix.length || col >= matrix.length;
                if (!isOut) {
                    matrix[row][col] = ch;
                }
                row += 2;
            }
        }
    }

    public static void printSquare(char[][] chars, char ch) {
        int len = chars.length;
        int half = len / 2;

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                boolean isPrint = (row == 0 || row == len - 1) || (col == 0 || col == len - 1);
                boolean isPrintE = ((row >= 5 && row <= 10) && col == 9) ||
                        (row == 5 && col >= 9 && col < 12) ||
                        (row == 11 && col >= 9 && col < 12) ||
                        (row == 8 && col >= 9 && col < 12);
                if (isPrint) {
                    System.out.print("\t" + ch);
                } else if (isPrintE) {
                    System.out.print(ANSI_YELLOW_BACKGROUND + "\t" + ' ' + ANSI_RESET);
                } else {
                    System.out.print(ANSI_BLUE_BACKGROUND + "\t" + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

}
