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


public class Day_27_Chess {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[33m";
    public static final String BLACK_BACK = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final int MAX_LENGTH = 8;
    public static String[][] field = new String[MAX_LENGTH][MAX_LENGTH];
    public static int[] posPlayer1 = new int[]{0, 6};
    public static int[] posPlayer2 = new int[]{7, 1};
    public static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {

        int counter = 52;
        String p1 = " K ";
        String p2 = " S ";
        boolean isPlayer1 = true;
        boolean isGameOver = false;

        initField(" _ ");


        while (!isGameOver) {
            counter--;

            setRandomMove(posPlayer1[0], posPlayer1[1], p1, " _ ");
            setRandomMove(posPlayer2[0], posPlayer2[1], p2, " _ ");

            var activePlayer = (isPlayer1) ? p1 : p2;
            var opponentPlayer = (isPlayer1) ? p2 : p1;

            var actualPos = activePlayer.equals(" K ") ? posPlayer1 : posPlayer2;
            //var opponentPos = getKnightPos(field, opponentPlayer);

            int r = actualPos[0];
            int c = actualPos[1];
            printField(field, " _ ");

            Thread.sleep(1000);
            System.out.println();
            var rand = getRandomMove(r,c);
            r = Integer.parseInt(rand.split("#")[0]);
            c = Integer.parseInt(rand.split("#")[1]);
            setRandomMove(r, c, activePlayer, " _ ");

            if (counter <= 0) {
                System.out.println("52 moves done - remis");
                break;
            }
            if (!actualPos.equals(actualPos)) {
                System.out.println(activePlayer + "wins");/**/
                break;
            } else {
                rand = getRandomMove(r,c);
                r = Integer.parseInt(rand.split("#")[0]);
                c = Integer.parseInt(rand.split("#")[1]);

                setRandomMove(r, c, activePlayer, " _ ");
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

    public static void printField(String[][] field, String str) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (field[i][j].equals(str)) {
                    if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
                        System.out.print(ANSI_WHITE_BACKGROUND + str + ANSI_RESET);
                    } else {
                        System.out.print(BLACK_BACK + str + ANSI_RESET);
                    }
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

    public static void setRandomMove(int row, int col, String player, String str) {

        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (!field[i][j].equals(str) && !field[i][j].equals(player)) {
                    field[i][j] = field[i][j];
                } else if (i == row && j == col) {
                    field[i][j] = player;
                    if (player.equals(" K ")){
                        posPlayer1 = new int[]{row, col};
                    } else {
                        posPlayer2 = new int[]{row, col};
                    }
                } else {
                    field[i][j] = str;
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
