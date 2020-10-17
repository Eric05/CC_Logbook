package com.company;

import com.company.Oktober.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;


public class Main {

    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String WHITE = "\033[0;37m";   // WHITE

    public static void main(String[] args) throws InterruptedException {

        List<String> strings = Arrays.asList(new String[]{"s", "a", "b"});
        strings.sort((b, a) -> a.compareTo(b));
        System.out.println(Arrays.asList(strings));
        String text = "Hel\\lo";
        String copied = new String(text);
        var sep = System.getProperty("file.separator");
        var y = text.compareTo("Hezlo");
        var z = text.compareTo("W");


        setTimeout(5, 5, 20);
        System.out.println();

        // String text = "Zur Zeit des Zweiten Weltkriegs nahm seine großen Werke Siddhartha und lahnte Der Steppenwolf noch ";

        System.out.println(text);
        System.out.println(text.length());

        var txt = text.replaceAll("h([m|n|l|r])", "$1");
        System.out.println(txt);
        System.out.println(txt.length());


        String[] arr = text.split(" ");

        List<String> list = Arrays.asList(arr);

        //var erg = Arrays.toString(list.toArray());
        // System.out.println(erg);
/*        var analyzer = new Day_12();

        System.out.println(analyzer.getChars());
        // any char [a-zA-Z0-9] ?
        System.out.println(analyzer.getSpokenChars());
        System.out.println(analyzer.countWords());
        System.out.println(analyzer.getLongestWord());
        // if digit 2 would be shortest
        System.out.println(analyzer.getShortestWord());
        // 24 + 3 * Hesses
        System.out.println(analyzer.countHesse());
        // more on just split if using clean list
        System.out.println(analyzer.countOnlyLowerOrUpper());

        List<Integer> list = Arrays.asList(new Integer[]{3, 5, 14, 18, 23, 22});
        int[] nums = new int[]{5, 2, 4, 22, 4, 34, 5};*/
    }

    public static void setTimeout(int max, int counter, int base) throws InterruptedException {

        boolean flag = false;

        if (counter == 0) {
            counter = max;
        }
//        if (base == 15) {
//            flag = true;
//        }
        if (base == 0) {
            flag = true;
            return;
        }

        Thread.sleep(200);
        System.out.println(counter);
        setTimeout(max, counter - 1, base - 1);

        if (!flag) {
            Thread.sleep(100);
            var res = (" i am useless code " + base * 100);
            System.out.println(res);
        }
    }


}





