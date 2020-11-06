package gameModi;

import gameController.AIController;
import gameController.GameController;
import gameController.GameState;
import gameController.Move;
import players.AIPlayer;
import players.HumanPlayer;
import players.Player;

import java.util.Scanner;

public class HumanVsAI {

    private  int level = 0;
    private GameController gc = new GameController();

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        if( level > 3) {
            this.level = 9;
        } else {
            this.level = level;
        }
    }

    public void humanVsAI() throws Exception {
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

            g.updateGameState();

            state = gc.checkState(g);
            if (state != 2) {
                isRunning = false;
                break;
            }

            ai.setDepth(7);
            var movX = ai.getBestMove(g, false, "o", "x", 0, 1, -1);
            g.ApplyMove(movX);

            g.updateGameState();
            gc.printGameState(g);
        }
    }
}
