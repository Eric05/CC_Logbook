package com.company.November.MovingKnight;

public class View {

    final int MAX_LENGTH = 8;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[33m";
    public static final String BLACK_BACK = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public void printField(String[][] field, String str) {
        for (int i = MAX_LENGTH - 1; i >= 0; i--) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (field[i][j].equals(str)) {
                    if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
                        System.out.print(ANSI_WHITE_BACKGROUND + str + ANSI_RESET);
                    } else {
                        System.out.print(BLACK_BACK + str + ANSI_RESET);
                    }
                } else {
                    System.out.print(ANSI_YELLOW_BACKGROUND + field[i][j] + ANSI_RESET);
                }
            }
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H  ");
    }
}
