package view;

import gameController.GameState;
import gameController.Move;

import java.util.Scanner;

public class View {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public int getGame(){
        System.out.println("Choose Game: [1] vs human [2] vs computer");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int getLevel(){
        System.out.println("Choose Dificulty: 0 - 9");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void printPlayerTurn(String symbol){

        System.out.println("_____________________________________");
        System.out.println(symbol + ": Make your move");
        System.out.println("-------------------------------------");
    }

    public void printSuccessPlayer1(){
        System.out.println("x win");
    }

    public void printMapping() {
        System.out.println();
        System.out.println("Use the correct number to choose your field:");
        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " | ");
            if (i % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void printGameState(GameState g) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (g.updateGameState()[i][j] == " ") {
                    System.out.print("_ ");
                } else if (g.updateGameState()[i][j] == "x") {
                    System.out.print( BLUE + "x " + ANSI_YELLOW);
                } else {
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
    }
    protected Move getMappedMoveFromInput(int input, String playerSymbol) {

        switch (input) {
            case 1:
                return new Move(0, 0, playerSymbol);
            case 2:
                return new Move(1, 0, playerSymbol);
            case 3:
                return new Move(2, 0, playerSymbol);
            case 4:
                return new Move(0, 1, playerSymbol);
            case 5:
                return new Move(1, 1, playerSymbol);
            case 6:
                return new Move(2, 1, playerSymbol);
            case 7:
                return new Move(0, 2, playerSymbol);
            case 8:
                return new Move(1, 2, playerSymbol);
            case 9:
                return new Move(2, 2, playerSymbol);
        }
        return null;
    }
}
