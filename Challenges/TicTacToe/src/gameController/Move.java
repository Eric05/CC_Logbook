package gameController;

public class Move {

    private int score;
    private int x;
    private int y;
    private String playerSymbol;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    // constructor 1: coordinates and playerSymbol
    public Move(int x, int y, String playerSymbol) {
        this.x = x;
        this.y = y;
        this.playerSymbol = playerSymbol;
    }

    // constructor 2: saves score for actual move
    public Move(int score) {
        this.score = score;
    }

    // default constructor
    public Move() {

    }
}

