package players;

import gameController.Move;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public Move getMove() {
        Scanner sc = new Scanner(System.in);
        return getMappedMoveFromInput(sc.nextInt(), symbol);

    }

    private Move getMappedMoveFromInput(int input, String playerSymbol) {

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
