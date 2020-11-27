package com.company.November.MovingRook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class GameController {

    final static int MAX_LENGTH = 8;
    final String fieldSymbol = "   ";
    static Random r = new Random();

    public void startGame() {
        var b = new Board(fieldSymbol);
        var v = new View();

        int counter = 0;
        boolean isPlayer1 = true;

        Player p1 = new Player(" R ", new int[]{0, 1});
        Player p2 = new Player(" r ", new int[]{7, 6});

        setMove(b, p1, fieldSymbol);
        setMove(b, p2, fieldSymbol);

        while (true) {

            Player active = (isPlayer1) ? p1 : p2;
            Player opponent = (isPlayer1) ? p2 : p1;

            String winningMove = getWinningMove(active, opponent);

            if (winningMove != null) {
                System.out.println(counter + " moves played " + active.getSymbol() + "wins");
                break;
            }
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter++;

            String randomMove = getRandomMove(active);

            active.setPosition(new int[]{Integer.parseInt(randomMove.split("#")[0]), Integer.parseInt(randomMove.split("#")[1])});
            setMove(b, active, fieldSymbol);

            v.printField(b.getBoard(), fieldSymbol);
            isPlayer1 = !isPlayer1;

        }

    }

    public static void setMove(Board b, Player active, String str) {

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

    public static String getWinningMove(Player active, Player opponent) {

        var rowActive = String.valueOf(active.getPosition()[0]);
        var rowOpponent = String.valueOf(opponent.getPosition()[0]);
        var colActive = String.valueOf(active.getPosition()[0]);
        var colOpponent = String.valueOf(opponent.getPosition()[1]);
        if (rowActive.equals(rowOpponent) || colActive.equals(colOpponent)) {
            return rowActive + "#" + colActive;
        }
        return null;
    }


    public static String getRandomMove(Player active) {

        int row = active.getPosition()[0];
        int col = active.getPosition()[1];

        var allMoves = getPossibleMoves(row, col);
        int rand = r.nextInt(allMoves.size() - 1);
        return allMoves.get(rand).split("#")[0] + "#" + allMoves.get(rand).split("#")[1];
    }

    public static List<String> getPossibleMoves(int row, int col) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == row && j != col) {
                    String pos = i + "#" + j;
                    list.add(pos);
                }
                if (j == col && i != row) {
                    String pos = i + "#" + j;
                    list.add(pos);
                }
            }
        }
        return list;
    }

}
