package com.company.September;

/*
Recursion Theorie
 */

import java.util.ArrayList;
import java.util.List;

public class Day_7 {

    // sum digits of num
    public static int sumDigit(int num) {

        if (num < 10) {
            return num;
        }
        int newNum = num % 10;
        int lastNum = num / 10;

        return newNum + sumDigit(lastNum);
    }

    // print out "Schaltjahre"
    //  % 4 == 0
    //  % 100 != 0 && % 400 == 0
    public static List<String> getLeepYears(int min, int max) {
        List<String> years = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                years.add(String.valueOf(i));
            }
        }
        return years;
    }
}
