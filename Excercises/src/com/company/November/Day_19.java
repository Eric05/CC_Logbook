package com.company.November;

import java.util.Random;

/***
 * 2D Array
 * // evaluation method for player 1 "4 Gewinnt"
 */

public class Day_19 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public static int[][] createRandom2D(int max) {
        var matrix = new int[max][max];

        for (int row = 0; row < max; row++) {
            for (int col = 0; col < max; col++) {
                var rand = getRandomInt(2);
                matrix[row][col] = rand;
            }
        }
        return matrix;
    }

    public static int[][] initField(int max) {
        var matrix = new int[max][max];

        return matrix;
    }

    public static void print2D(int[][] matrix) {
        int max = matrix.length;

        for (int row = 0; row < max; row++) {
            for (int col = 0; col < max; col++) {

                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public static long sumArray(int[][] matrix) {
        long res = 0;

        for (var cols : matrix) {
            for (var row : cols) {
                res += (long) row;
            }
        }
        return res;
    }

    public static void printField(int[][] field) {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 1) {
                    System.out.print(  "\t" + ANSI_YELLOW_BACKGROUND +" "+ field[i][j]+" " + ANSI_RESET );
                } else if (field[i][j] == 2) {
                    System.out.print("\t" + ANSI_BLUE_BACKGROUND +" "+ field[i][j]+" " + ANSI_RESET  );
                } else {
                    System.out.print("\t" +" "+ field[i][j]+" ");
                }
            }
            System.out.println();
        }
    }



    // evaluation method for player 1 "4 Gewinnt"
    public static String evaluate(int[][] matrix) {
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
                        return "P1 -> horizontal hit: " + row + " " + col;
                    }
                } else if (!isOut && matrix[row][col] == 4) {
                    sum2++;
                    if (sum2 == 4) {
                        return "P2 -> horizontal hit: " + row + " " + col;
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
                        return "vertical hit: " + row + " " + col;
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
                        return "downright: " + row + " " + col;
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
                        return "downleft: " + row + " " + col;
                    }
                } else {
                    sum1 = 0;
                }
            }
        }


        return "no hit " + sum0 + " fields empty";
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


    private static int getRandomInt(int max) {
        Random r = new Random();

        return r.nextInt(max + 1);
    }


}
