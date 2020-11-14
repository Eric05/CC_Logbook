package gameController;

import gameModi.HumanVsAI;
import gameModi.HumanVsHuman;
import gameModi.HumanVsRandom;
import gameModi.Simulation;
import players.HumanPlayer;
import players.Player;
import view.View;

import java.util.Scanner;

public class GameController {

    private int level = 9;
    private int game = 0;
    private View v = new View();

    public void getSettings() {
        getGame();
        getLevel();
    }

    private void getLevel() {
        game = v.getLevel();
    }

    private void getGame() {
        level = v.getGame();
    }

    public void printPlayerTurn(String symbol){
        v.printPlayerTurn(symbol);
    }


    public void simulate() throws Exception {
        var sim = new Simulation();
        sim.simulate(9,1);
    }

    public void humanVsAI() throws Exception {
        var ai = new HumanVsAI();
        ai.humanVsAI();
    }

    public void humanVsRandom() throws Exception {
        var random = new HumanVsRandom();
        random.humanVsRandom(this);
    }

    public void humanVsHuman() throws Exception {
        var human = new HumanVsHuman();
        human.humanVsHuman(this);
    }

    public int checkState(GameState g) {
        var res = g.EvaluateState();
        switch (res) {
            case 0:
                System.out.println("draw");
                return 0;
            case 1:
                System.out.println("x win");
                return 1;
            case -1:
                System.out.println("o win");
                return -1;
        }
        return 2;
    }

    public void printMapping() {
        v.printMapping();
    }

    public void printGameState(GameState g) {
        v.printGameState(g);
    }

}
