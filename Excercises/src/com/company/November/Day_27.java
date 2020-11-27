package com.company.November;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Knight Move
 * <p>
 * printField
 * doRandomMove
 * isGameOver
 */


public class Day_27 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[33m";
    public static final int MAX_LENGTH = 8;
    public static String[][] field = new String[MAX_LENGTH][MAX_LENGTH];
    public static int[] posPlayer1 = new int[]{0,7};
    public static int[] posPlayer2 = new int[]{7,0};
    public static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {

        int counter = 52;
        String p1 = " K ";
        String p2 = " S ";
        boolean isPlayer1 = true;
        boolean isGameOver = false;

        initField(" + ");

        while (!isGameOver) {
            counter--;

            var activePlayer = (isPlayer1) ? p1 : p2;
            var opponentPlayer = (isPlayer1) ? p2 : p1;

            setRandomMove(posPlayer1[0],posPlayer1[1], activePlayer);
            setRandomMove(posPlayer2[0], posPlayer2[1], opponentPlayer);

            var actualPos = getKnightPos(field, activePlayer);
            var opponentPos =  getKnightPos(field,opponentPlayer);

            int r = Integer.parseInt(actualPos.split("#")[0]);
            int c = Integer.parseInt(actualPos.split("#")[1]);
            printField(field, ANSI_RESET + activePlayer + ANSI_RESET, r, c);

            Thread.sleep(1000);
            System.out.println();
            var rand = getRandomMove(r, c);
            if (counter <= 0) {
                System.out.println("52 moves done - remis");
                break;
            }
            if (rand.equals(actualPos)) {
                System.out.println(activePlayer + "wins");/**/
                break;
            } else {
                r = Integer.parseInt(rand.split("#")[0]);
                c = Integer.parseInt(rand.split("#")[1]);

                setRandomMove(r, c, activePlayer);
            }
            isPlayer1 = isPlayer1 ? false : true;
        }

    }

    public static void initField(String str) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                field[i][j] = str;
            }
        }
    }

    public static void printField(String[][] field, String knight, int posRow, int posCol) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (i == posRow && j == posCol) {
                    System.out.print(knight);
                } else {
                    System.out.print(ANSI_YELLOW_BACKGROUND + field[i][j] + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    public static String getKnightPos(String[][] field, String player) {

        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (field[i][j].equals(player)) {
                    return i + "#" + j;
                }
            }
        }
        if (player.equals(" K ")) {
            return MAX_LENGTH - 1 + "#" + 0;
        }
        return "0" + "#" + (MAX_LENGTH - 1);
    }

    public static void setRandomMove(int row, int col, String player) {

        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (!field[i][j].equals(" + ") && !field[i][j].equals(player)) {
                    field[i][j] = field[i][j];
                } else if (i == row && j == col) {
                    field[i][j] = player;
                } else {
                    field[i][j] = " + ";
                }
            }
        }
    }

    public static String getRandomMove(int row, int col) {

        var moves = getPossibleMoves(row, col, false);
        var random = r.nextInt(moves.size());

        return moves.get(random);
    }

    public static List<String> getPossibleMoves(int row, int col, boolean forward) {
        int X[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int Y[] = {1, 2, 2, 1, -1, -2, -2, -1};

        List<String> possibleMoves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {

            // Position after move
            int x = row + X[i];
            int y = col + Y[i];

            // valid moves + only move forward( -> y--)
            boolean fw = (forward) ? (x >= 0 && y >= 0 && x < MAX_LENGTH && y < MAX_LENGTH && x < row)
                    : (x >= 0 && y >= 0 && x < MAX_LENGTH && y < MAX_LENGTH);
            if (fw) {
                possibleMoves.add(x + "#" + y);
            }
        }
        return possibleMoves;
    }
}
