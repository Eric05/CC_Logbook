package com.company;

import com.company.November.Day_19;
import com.company.November.Day_20;
import com.company.November.Day_20_PrintSquare;
import com.company.Oktober.Holiday.Christmas;
import com.company.Oktober.Holiday.GuessingGame;

import java.security.KeyPair;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
1: teenSum - Boolean
Gegeben sind 2 ints a und b. Geben Sie ihre Summe zurück.
"Teen" - Werte im Bereich von 13 bis 19 sind jedoch besonders.
Wenn einer der beiden Werte ein Teenager ist, geben Sie einfach 19 zurück.
teenSum(3, 4) → 7 // teenSum(10, 13) → 19

2: noFirstLast - Strings
Geben Sie bei einer gegebenen Zeichenfolge eine Version ohne das erste und letzte Zeichen zurück,
sodass "Hallo" -> "all" ergibt.

3: swapEnds - Arrays)
Tauschen Sie das 1. und das letzte Element eines Arrays von ints.
[1,2,3,4] -> [4,2,3,1]
*/

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[30m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public static void main(String[] args) throws Exception {

        String str = "Hallo";
        var ch = ' ';
        String x = str.replaceAll(Character.valueOf(str.charAt(0)).toString(), "");


        Day_20.init();
    }



}









