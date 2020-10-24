import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIController {

    private int depth = 9;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Move getRandomMove(GameState g, String playerSymbol) {

        var field = g.updateGameState();
        List<Move> possibleMoves = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == " ") {
                    possibleMoves.add(new Move(j, i, playerSymbol));
                }
            }
        }
        var rand = new Random();

        // if List Size == 1 return only that move
        var randomSize = (possibleMoves.size() > 1) ? rand.nextInt(possibleMoves.size() - 1) : 0;
        return possibleMoves.get(randomSize);
    }

    // x = human player - > maximizing (bool isMax)
    public Move getBestMove(GameState g, boolean isMax, String currentPlayer, String otherPlayer, int depth) throws Exception {

        int score = g.EvaluateState();

        if (depth == getDepth()) {
            return new Move((score));
        }
        if (score != 2) {
            return new Move(score);
        }

        Move bestMove = new Move();

        // Initial value of move reversed
        if (isMax) {
            bestMove.setScore(Integer.MIN_VALUE);
        } else {
            bestMove.setScore(Integer.MAX_VALUE);
        }

        // create List of possible moves from actual gameState for actual player
        var nextMoves = g.GenerateNextMoves(currentPlayer);

        for (var move : nextMoves) {
            g.ApplyMove(move);
            if (isMax) {
                Move possibleBestMove = getBestMove(g, !isMax, otherPlayer, currentPlayer, depth + 1);
                if (possibleBestMove.getScore() > bestMove.getScore()) {
                    bestMove.setX(move.getX());
                    bestMove.setY(move.getY());
                    bestMove.setScore(possibleBestMove.getScore());
                }
            } else {
                Move possibleBestMove = getBestMove(g, !isMax, otherPlayer, currentPlayer, depth + 1);
                if (possibleBestMove.getScore() < bestMove.getScore()) {
                    bestMove.setX(move.getX());
                    bestMove.setY(move.getY());
                    bestMove.setScore(possibleBestMove.getScore());
                }
            }
            // reset actual move to use field for next evaluation
            g.UndoMove(move);
        }
        return bestMove;
    }
}
