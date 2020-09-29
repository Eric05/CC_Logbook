package com.company.September;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
Recursion Recursion .......... rec :)
void learnRecursion(getTime)
if ( time > 14:00) {
goHome();
}
learnRecursion(getTime);
 */

public class Day_6 {

    // print number in L form
    public static void printNun(int num) {
        if (num < 1)
            return;
        else {
            System.out.println(num);
            printNun(num - 1);
            System.out.print(num + "\t");
            return;
        }
    }

    // calculate Fibonacci
    public static int getFib(int num) {
        if (num <= 1) {
            return 1;
        }
        return getFib(num - 1) + getFib((num - 2));
    }

    // print Factorial recursively
    public static double printFactorial_rec(double num) {
        if (num == 0)
            return 1;
        else
            return (num * printFactorial_rec((double) num - 1));
    }

    // reverse String by Recursion
    public static String reverseString(String str) {

        if (str.length() <= 0) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // get all combinations of string and return it in list
    public static List<String> permutations(char[] chars, int index, List<String> list) {

        if (index == chars.length - 1) {
            list.add(String.valueOf(chars));
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutations(chars, index + 1, list);
            swap(chars, index, i);
        }
        return list;
    }

    private static void swap(char[] chars, int a, int b) {
        var tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
    //----------------------------------------------------------------------------------

    // get files recursively and return list of Strings
    public static List<String> getFiles(String path, List<String> list) {
        var root = new File(path);
        var files = root.listFiles();

        if (files == null) {
            return null;
        }
        for (var f : files) {
            if (f.isDirectory()) {
                getFiles(f.getAbsolutePath(), list);
                list.add("Dir: " + f.getAbsoluteFile());
            } else {
                list.add("\tFile: " + f.getAbsoluteFile());
            }
        }
        return list;
    }
}
