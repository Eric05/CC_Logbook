import gameController.AIController;
import gameController.GameState;
import gameController.GameController;
import players.HumanPlayer;
import gameController.Move;
import players.Player;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        // !!!! TODO - fix depth
        // TODO - fix alpha/beta pruning - performance test
        // TODO - Interface for view, controller ... abstract method for gameflow and simulation
        // TODO - const for length ... const for MIN and MAX value
        // TODO - shuffle List of equal moves for more fun :)


        GameController gc = new GameController();

        for (int i = 0; i < 10; i++) {

            gc.simulate();
            System.out.println("#############################################################################");
            Thread.sleep(1000);
        }


    }
}
