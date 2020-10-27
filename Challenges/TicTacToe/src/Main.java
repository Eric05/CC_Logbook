public class Main {

    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) throws Exception {

        // TODO - alpha/beta pruning improved
        // TODO - Interface for view, controller ... abstract method for gameflow and simulation
        // TODO - const for length ... const for MIN and MAX value
        // TODO - shuffle List of equal moves for more fun :)

        int state = 2;
        boolean isRunning = true;
        GameState g = new GameState();
        var ai = new AIController();
        printMapping();

        // simulation minmax(small depth) vs minmax(max depth)
        while (isRunning) {

            state = checkState(g);
            if (state != 2) {
                isRunning = false;
                break;
            }

            ai.setDepth(1);
            var movY = ai.getBestMove(g, true, "x", "o", 0, 1, -1);
            g.ApplyMove(movY, "x");
            g.updateGameState();

            System.out.println("_____________________________________");
            System.out.println(BLUE + "x plays:");
            System.out.println("-------------------------------------");
            Thread.sleep(1000);
            printGameState(g);

            state = checkState(g);
            if (state != 2) {
                isRunning = false;
                break;
            }

            g.updateGameState();
            ai.setDepth(9);
            var movX = ai.getBestMove(g, false, "o", "x", 0, 1, -1);
            g.ApplyMove(movX);

            System.out.println("-------------------------------------");
            System.out.println("o plays: ");
            System.out.println("-------------------------------------");
            Thread.sleep(1000);
            printGameState(g);

        }

        // human vs random
//        int state = 2;
//        boolean isRunning = true;
//        GameState g = new GameState();
//        var ai = new AIController();
//        printMapping();
//
//        while (isRunning) {
//
//            state = checkState(g);
//            if (state != 2) {
//                isRunning = false;
//                break;
//            }
//
//            System.out.println("Player x - its your turn");
//            printGameState(g);
//            Scanner sc = new Scanner(System.in);
//            Move m1 = getMove(sc.nextInt(), "x");
//            g.ApplyMove(m1);
//            g.getGameState();
//            state = checkState(g);
//            if (state != 2) {
//                isRunning = false;
//                break;
//            }
//            //printGameState(g);
//
//            var mov = ai.doRandomMove(g, "o");
//            g.ApplyMove(mov);
//            g.getGameState();
//             printGameState(g);
//        }

    }


    public static int checkState(GameState g) {
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

    public static Move getMove(int input, String playerSymbol) {

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

    public static void printMapping() {
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

    public static void printGameState(GameState g) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (g.updateGameState()[i][j] == " ") {
                    System.out.print("_ ");
                } else if (g.updateGameState()[i][j] == "x") {
                    System.out.print("x ");
                } else {
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
    }
}
