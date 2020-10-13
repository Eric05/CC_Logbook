package com.company;

import com.company.Oktober.Day_10;
import com.company.Oktober.Day_11;
import com.company.Oktober.Day_12;
import com.company.Oktober.Day_9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String WHITE = "\033[0;37m";   // WHITE

    public static void main(String[] args) throws InterruptedException {

          var analyzer = new Day_12();

        System.out.println(analyzer.getChars());
        // any char [a-zA-Z0-9] ?
        System.out.println(analyzer.getSpokenChars());
        System.out.println(analyzer.countWords());
        System.out.println(analyzer.getLongestWord());
        // if digit 2 would be shortes
        System.out.println(analyzer.getShortestWord());
        // 24 + 3 * Hesses
        System.out.println(analyzer.countHesse());
        // more on just split if using clean list
        System.out.println(analyzer.countOnlyLowerOrUpper());

        List<Integer> list = Arrays.asList(new Integer[]{3, 5, 14, 18, 23, 22});
        int[] nums = new int[]{5, 2, 4, 22, 4, 34, 5};

        //long result = Day_11.printFactorial(5, new HashMap<>());

        String[] names = {"Dan.", " Benny", "clyde>", "Eric", "Simpson", "becky", "Dan", "Olli"};


        var cleanNames = Arrays.asList(names);
        cleanNames = cleanNames.stream().map(s -> s = s.replaceAll("[^a-zA-Z0-9]", "")).collect(Collectors.toList());


    }

}



