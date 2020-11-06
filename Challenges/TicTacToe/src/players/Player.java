package players;


import gameController.Move;

public abstract class Player {

    protected String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected String name;
    protected String color;

    public Player(String name, String color, String symbol) {
        this.name = name;
        this.color = color;
        this.symbol = symbol;
    }

    public Player() {

    }


    public abstract Move getMove();

}
