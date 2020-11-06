package gameController;

import gameController.Move;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private String[][] gameField = new String[3][3];
    public static int GAME_WIDTH = 3;
    public static int GAME_HEIGHT = 3;
    public static int WIN_COUNT = 3;

    public GameState() {
        initField();
    }

    public String[][] updateGameState() {
        return gameField;
    }

    public void initField() {
        for (int y = 0; y < GAME_HEIGHT; y++) {
            for (int x = 0; x < GAME_WIDTH; x++) {
                gameField[y][x] = " ";
            }
        }
    }

    public int EvaluateState() {
        int playerXCountHorizontal = 0;
        int playerXCountVertical = 0;
        int playerOCountVertical = 0;
        int playerOCountHorizontal = 0;
        int fieldCounter = 0;

        for (var y = 0; y < GAME_HEIGHT; y++) {
            // reset Counter for each line
            playerXCountHorizontal = 0;
            playerXCountVertical = 0;
            playerOCountHorizontal = 0;
            playerOCountVertical = 0;

            // inner loop
            for (var x = 0; x < GAME_WIDTH; x++) {
                // horizontal check
                if (gameField[y][x] != " ") {
                    if (gameField[y][x] == "x") {
                        playerXCountHorizontal++;
                    } else {
                        playerOCountHorizontal++;
                    }
                } else {
                    fieldCounter++; // if field is empty
                }
                // vertical check
                if (gameField[x][y] != " ") {
                    if (gameField[x][y] == "x") {
                        playerXCountVertical++;
                    } else {
                        playerOCountVertical++;
                    }
                }
            }
            // end inner loop -> test if there is a winner
            if (playerOCountVertical == WIN_COUNT || playerOCountHorizontal == WIN_COUNT) {
                return -1;
            }
            if (playerXCountHorizontal == WIN_COUNT || playerXCountVertical == WIN_COUNT) {
                return 1;
            }
        }

        // check diagonals
        int playerXCountDiagonal = 0;
        int playerOCountDiagonal = 0;
        int playerOCountDiagonal2 = 0;
        int playerXCountDiagonal2 = 0;

        for (int i = 0, j = GAME_HEIGHT - 1; i < GAME_HEIGHT && j >= 0; i++, j--) {
            if (gameField[i][i] != " ") {
                if (gameField[i][i] == "x") {
                    playerXCountDiagonal++;
                } else {
                    playerOCountDiagonal++;
                }
            }
            if (gameField[i][j] != " ") {
                if (gameField[i][j] == "x") {
                    playerXCountDiagonal2++;
                } else {
                    playerOCountDiagonal2++;
                }
            }
        }
        if (playerXCountDiagonal == WIN_COUNT || playerXCountDiagonal2 == WIN_COUNT) {
            return 1;
        }
        if (playerOCountDiagonal == WIN_COUNT || playerOCountDiagonal2 == WIN_COUNT) {
            return -1;
        }

        // if no winner check for draw
        if (fieldCounter == 0) {
            return 0;
        }
        return 2;
    }

    // all possible moves from actual gameState
    public List<Move> GenerateNextMoves(String playerSymbol) {
        List<Move> moves = new ArrayList<>();
        for (int y = 0; y < GAME_HEIGHT; y++) {
            for (int x = 0; x < GAME_WIDTH; x++) {
                if (gameField[y][x] == " ") {
                    moves.add(new Move(x, y, playerSymbol));
                }
            }
        }
        return moves;
    }

    // apply move to gameState - if human makes illegal move...
    public void ApplyMove(Move m) throws Exception {
        if (gameField[m.getY()][m.getX()] != " ") {
            throw new Exception("Invalid Players.Move");
        }
        gameField[m.getY()][m.getX()] = m.getPlayerSymbol();
    }

    // overload for output
    public void ApplyMove(Move m, String playerSymbol) throws Exception {
        if (gameField[m.getY()][m.getX()] != " ") {
            throw new Exception("Invalid Players.Move");
        }
        gameField[m.getY()][m.getX()] = playerSymbol;
    }

    // ...undo move
    public void UndoMove(Move m) {
        gameField[m.getY()][m.getX()] = " ";
    }
}

