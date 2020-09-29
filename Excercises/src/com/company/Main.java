package com.company;

import com.company.September.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var years = Day_7.getLeepYears(1800, 2040);
        printLeepYears(years);

    }

    public static void printLeepYears(List<String> years) {
        var counter = 0;
        for (var y : years) {
            counter++;
            if (counter % 20 == 0) {
                System.out.println("");
            }
            System.out.print((char) 27 + "[32m" + y + ", ");
        }
    }
}

