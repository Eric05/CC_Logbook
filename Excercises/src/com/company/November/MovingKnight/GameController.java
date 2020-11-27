package com.company.November.MovingKnight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameController {

    final static int MAX_LENGTH = 8;
    final String fieldSymbol = "   ";
    static Random r = new Random();

    public void startGame() {
        var b = new Board(fieldSymbol);
        var v = new View();

        int counter = 0;
        boolean isPlayer1 = true;
        boolean isGameOver = false;

        Player p1 = new Player(" K ", new int[]{0, 1});
        Player p2 = new Player(" k ", new int[]{7, 6});

        setMove(b, p1, p2, fieldSymbol);
        setMove(b, p2, p1, fieldSymbol);
        v.printField(b.getBoard(), fieldSymbol);

        while (!isGameOver) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;

            if (counter >= 52) {
                System.out.println("52 Moves played - remis");
                isGameOver = true;
                break;
            }

            Player active = (isPlayer1) ? p1 : p2;
            Player opponent = (isPlayer1) ? p2 : p1;

            // after ten random moves both are looking for winning move - as in chess it s half move ->
            // second player will always win in this scenario
            if (counter > 10) {
                String winningMove = getWinningMove(active, opponent);

                if (winningMove != null) {
                    System.out.println(counter + " moves played " + active.getSymbol() + "wins");
                    isGameOver = true;
                    break;
                }
            }
            String randomMove = getRandomMove(active);

            active.setPosition(new int[]{Integer.parseInt(randomMove.split("#")[0]), Integer.parseInt(randomMove.split("#")[1])});
            setMove(b, active, opponent, fieldSymbol);

            v.printField(b.getBoard(), fieldSymbol);
            isPlayer1 = !isPlayer1;
        }
    }

    public static void setMove(Board b, Player active, Player opponent, String str) {

        String[][] field = b.getBoard();
        int row = active.getPosition()[0];
        int col = active.getPosition()[1];
        String symbol = active.getSymbol();

        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (field[i][j].equals(str) || field[i][j].equals(active.getSymbol())) {
                    field[i][j] = str;
                }
                if (i == row && j == col) {
                    b.updateBoard(row, col, symbol);
                }
            }
        }
    }

    public static String getRandomMove(Player active) {

        var moves = getPossibleMoves(active.getPosition()[0], active.getPosition()[1], false);
        var random = r.nextInt(moves.size());

        return moves.get(random);
    }

    public static String getWinningMove(Player active, Player opponent) {
        var moves = getPossibleMoves(active.getPosition()[0], active.getPosition()[1], false);

        String posP2 = opponent.getPosition()[0] + "#" + opponent.getPosition()[1];

        for (String move : moves) {
            if (move.equals(posP2)) {
                return move;
            }
        }
        return null;
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
