package com.company.November.MovingKnight;

public class Board {

    final int MAX_SIZE = 8;
    String[][] board = new String[MAX_SIZE][MAX_SIZE];

    public String[][] getBoard() {
        return board;
    }

    public Board(String str) {
        initField(str);
    }

    public void updateBoard(int row, int col, String str) {
        board[row][col] = str;
    }

    public String[][] initField(String str) {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                board[i][j] = str;
            }
        }
        return board;
    }
}
