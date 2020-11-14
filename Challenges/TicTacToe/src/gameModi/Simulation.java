package gameModi;

import gameController.AIController;
import gameController.GameController;
import gameController.GameState;
import view.View;

public class Simulation {

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    private View v = new View();
    private GameController gc = new GameController();

    public void simulate(int levelX, int levelO) throws Exception {

        int state = 2;
        boolean isRunning = true;
        GameState g = new GameState();
        var ai = new AIController();
        //v.printMapping();

        // simulation minmax(small depth) vs minmax(max depth)
        while (isRunning) {

            state = gc.checkState(g);
            if (state != 2) {
                isRunning = false;
                            break;
            }

            ai.setDepth(9);
            var movX = ai.getBestMove(g, true, "x", "o", 0, 1, -1);
            g.ApplyMove(movX, "x");
            g.updateGameState();

            System.out.println("");
            System.out.println(BLUE + "x plays:" + ANSI_CYAN);
            //System.out.println("");
            Thread.sleep(1000);
            v.printGameState(g);

            state = gc.checkState(g);
            if (state != 2) {
                isRunning = false;
                break;
            }

            g.updateGameState();
            ai.setDepth(1);
            //var movY = ai.getRandomMove(g,"o");
            var movY = ai.getBestMove(g, false, "o", "x", 0, 1, -1);
            g.ApplyMove(movY);

            System.out.println("");
            System.out.println("o plays: ");
            //System.out.println("");
            Thread.sleep(1000);
            v.printGameState(g);
        }
    }
}
