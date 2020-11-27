package com.company.November.MovingKnight;

public class Player {
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public Player(String symbol, int[] position) {
        this.symbol = symbol;
        this.position = position;
    }

    private String symbol;
    private int[] position = new int[2];
}
