package com.company.September;

    /*
    Excercises Day 2:
    - Operators: Assignment and Arithmetic
    - if else
    - Loops...
    - Nested For Loop to print Square with letters
     */


public class Day_2 {

    // Print Number
    public static void PrintNumbers(int max) {
        int res = 0;
        for (int i = 1; i < max; i++) {
            res += i;
            System.out.println(res);

            /* if loop should break on specific result
            if (res >= max) {
                break;
            }
             */
        }
    }

    // Print Factorial
    public static void printFactorial(long max) {
        int res = 1;
        for (int i = 1; i < max; i++) {
            res *= i;
            System.out.println(res);
        }
    }

    // Print Square with letter
    static void printSquareWithLetter(int max, String letter) {
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                System.out.print(letter);
            }
            System.out.println();
        }
    }


    // ##################################################################### advanced Version :) #################

    // Calculate Pi
    public double CalcPi(double baseNum, int max) {

        double res = baseNum;
        double divider = 1.0d;
        String res1 = "";
        String res2 = "";
        String isAdd = "";

        for (int i = 0; i < max; i++) {
            divider += 2;

            if (i % 2 == 1) {
                res += Add(baseNum, divider);
                res1 = String.valueOf(res);
                isAdd = ("+");
            } else {
                res += Minus(baseNum, divider);
                res2 = String.valueOf(res);
                isAdd = ("-");
            }
            PrintOutput("Iteration " + i + " " + res1 + " " + isAdd + " " + res2);
            PrintOutput(" Result: " + res);
        }
        return res;
    }

    public double Add(double num1, double num2) {
        return num1 / num2;
    }

    public double Minus(double num1, double num2) {
        return -1 * (num1 / num2);
    }

    public void PrintOutput(String output) {
        System.out.println(output);
    }





}
