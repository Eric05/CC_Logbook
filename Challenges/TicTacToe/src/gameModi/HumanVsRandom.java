package gameModi;

import gameController.AIController;
import gameController.GameController;
import gameController.GameState;
import gameController.Move;
import players.AIPlayer;
import players.HumanPlayer;
import players.Player;

import java.util.Scanner;

public class HumanVsRandom {

    private GameController gc = new GameController();


    public void humanVsRandom(GameController gameController) throws Exception {
        Player player1 = new HumanPlayer();
        Player player2 = new AIPlayer();

        Player activePlayer = player1;
        player1.setSymbol("x");
        player2.setSymbol("o");

        int state = 2;
        boolean isRunning = true;
        GameState g = new GameState();
        var ai = new AIController();
        gc.printMapping();

        while (isRunning) {

            state = gc.checkState(g);
            if (state != 2) {
                isRunning = false;
                break;
            }

            gc.printPlayerTurn(activePlayer.getSymbol());
            var movActive = activePlayer.getMove();
            g.ApplyMove(movActive, activePlayer.getSymbol());

            state = gc.checkState(g);
            if (state != 2) {
                isRunning = false;
                break;
            }

            var mov = ai.getRandomMove(g, "o");
            g.ApplyMove(mov);

            g.updateGameState();
            gc.printGameState(g);
        }
    }
}
