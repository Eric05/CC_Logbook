package com.company.Tests;

import java.util.*;

import java.util.Random;

/***
 * 1#Schachbrett mit Zahlen und Buchstaben.                                     (String [19][19])
 * 2#Startposition KW(Knight weiß) auf A1 und KS(Knight schwarz) auf H8.        (int [2],int posB,int posZ)
 * 3#Knights abwechslungsweise einen Zug machen.                                (boolean weiß)
 * 4#Zufall Zug vom Knight(8 möglichkeiten).                                    (int [8], Random zufallzahl, int jump,)
 * 5#Prüfen ob das Pferd auf dem Schachbrett bleibt.                            if(<>)
 * 6#Ende wenn die Pferde sich treffen,                                          if(posKW==posKS)
 * 7#Welches Pferd hat das andere geschlagen?
 */

class ChessTwoKnight3 {
    public static void main(String[] args) {
        String[][] chessboard = {
                {"     ", ",", "  A  ", ",", "  B  ", ",", "  C  ", ",", "  D  ", ",", "  E  ", ",", "  F  ", ",", "  G  ", ",", "  H  ", ",", "     "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  8  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  8  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  7  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  7  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  6  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  6  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  5  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  5  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  4  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  4  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  3  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  3  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  2  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  2  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  1  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  1  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"     ", "'", "  A  ", "'", "  B  ", "'", "  C  ", "'", "  D  ", "'", "  E  ", "'", "  F  ", "'", "  G  ", "'", "  H  ", "'", "     "},
        };
        int posLRW = 16;//position buchstabenreihe weiß(position letters row white)
        int posNRW = 2;//position zahlenreihe weiß(position numbers row white)
        int posLRS = 2;//position buchstabenreihe schwarz(position letters row black)
        int posNRS = 16;//position zahlenreihe schwarz(position numbers row black)
        String knightW = " KW  ";
        String empty = "     ";
        String knightB = " KS  ";
        int[] knightWPos = {posLRW, posNRW};
        int[] knightBPos = {posLRS, posNRS};
        int[] allowedPos;
        chessboard[knightWPos[0]][knightWPos[1]] = knightW;
        chessboard[knightBPos[0]][knightBPos[1]] = knightB;
        printChessboard(chessboard);
        boolean white = true;//weiß beginnt
        boolean beat = false;//prüfung ob ein pferd geschlageb wird
        while (!beat) {
            Random randomPos = new Random();//zufall wird ermittelt
            boolean allowedMove = false;
            int posL = 0;//position buchstaben
            int posN = 0;//position zahlen
            while (!allowedMove) {
                int jump = randomPos.nextInt(8);
                switch (jump) {
                    case 0: posL = +4; posN = +2;break;
                    case 1: posL = +4; posN = -2;break;
                    case 2: posL = -4; posN = +2;break;
                    case 3: posL = -4; posN = -2;break;
                    case 4: posL = +2; posN = +4;break;
                    case 5: posL = +2; posN = -4;break;
                    case 6: posL = -2; posN = +4;break;
                    case 7: posL = -2; posN = -4;break;
                }
                if (white) {
                    allowedPos = knightWPos;
                } else {
                    allowedPos = knightBPos;
                }
                allowedMove = isAllowed(allowedPos, posL, posN);//prüfung ob das Pferd auf dem schachbrett bleibt
            }
            if (white) {
                chessboard[knightWPos[0]][knightWPos[1]] = empty;//aktuelle position wird geleert
                knightWPos[0] += posL;
                knightWPos[1] += posN;
                chessboard[knightWPos[0]][knightWPos[1]] = knightW;//neue position wird befüllt
                printChessboard(chessboard);
            } else {
                chessboard[knightBPos[0]][knightBPos[1]] = empty;
                knightBPos[0] += posL;
                knightBPos[1] += posN;
                chessboard[knightBPos[0]][knightBPos[1]] = knightB;
                printChessboard(chessboard);
            }
            white = !white;//spieler wechsln
            beat = isHit(knightWPos, knightBPos);
        }
        if (!white) {
            System.out.println("Weiß schlägt schwarz!");
        } else System.out.println("Schwarz schlägt Weiß!");
    }

    private static boolean isHit(int[] knightWPos, int[] knightSPos) {
        //  return knightWPos[0] == knightSPos[0] && knightWPos[1] == knightSPos[1];
        return knightSPos[0] == knightWPos[0] && knightSPos[1] == knightWPos[1];

    }

    private static boolean isAllowed(int[] posErlaubt, int posB, int posZ) {
        return posErlaubt[0] + posB >= 2 && posErlaubt[0] + posB <= 16 && posErlaubt[1] + posZ >= 2 && posErlaubt[1] + posZ <= 16;
    }

    private static void printChessboard(String[][] spielfeld) {
        for (String[] reihe : spielfeld) {
            for (String aString : reihe) {
                System.out.print(aString);
            }
            System.out.println();
        }
        System.out.println("===========================================================");
    }
}




