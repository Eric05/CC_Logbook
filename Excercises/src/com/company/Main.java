package com.company;

import com.company.Oktober.Day_10;
import com.company.Oktober.Day_11;
import com.company.Oktober.Day_9;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String WHITE = "\033[0;37m";   // WHITE

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = Arrays.asList(new Integer[]{3, 5, 14, 18, 23, 22});
        int[] nums = new int[]{5, 2, 4, 22, 4, 34, 5};

       int result = addition();

        System.out.println(result);
        //sayHello();
        //var res = Day_10.getPasc(5);
        //System.out.println( res);
        //Day_11.sayHello();

        //Day_10.printTriangle(500);

        //Day_9.rec("hello", 6, 1);
        //Day_8.compareBubblessorts();

        String[] names = {"Dan", "Benny", "clyde", "Eric", "Simpson", "becky", "Dan", "Olli"};
        List<String> listNames = Arrays.asList(names);
        var erg = Day_9.filterNums(listNames);


        // Day_8_Schoolclass.printInfo(names);
    }

    //       Rückgabetyp funktions name
    public static String returnSeven() {

        return "7";

    }
    public static void sayHello() {

        int a = 12;
        int b = 23;
        int erg = a +  b;
        System.out.println(erg);

    }

    public static int addition(){

        int a = 100;
        int b = 50;
        int erg = a - b;

        return erg;
    }
}

