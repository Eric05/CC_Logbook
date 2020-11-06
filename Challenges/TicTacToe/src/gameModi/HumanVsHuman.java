package gameModi;

import gameController.GameController;
import gameController.GameState;
import players.HumanPlayer;
import players.Player;

public class HumanVsHuman {

    private GameController gc = new GameController();

    public void humanVsHuman(GameController gc) throws Exception {
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();

        Player activePlayer = player1;
        player1.setSymbol("x");
        player2.setSymbol("o");

        int state = 2;
        boolean isRunning = true;
        GameState g = new GameState();

        gc.printMapping();
        gc.printGameState(g);

        while (isRunning) {

            state = gc.checkState(g);
            if (state != 2) {
                isRunning = false;
                break;
            }
            gc.printPlayerTurn(activePlayer.getSymbol());

            var movActive = activePlayer.getMove();
            g.ApplyMove(movActive, activePlayer.getSymbol());

            g.updateGameState();
            gc.printGameState(g);

            activePlayer = player1 == activePlayer ? player2 : player1;
        }
    }
}
