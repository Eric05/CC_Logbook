package com.company.September;

/*
  Excercises Day 3:
  - Loops...
  - Nested For Loop for einmaleins, prime
  - Array check Palindrome
   */

public class Day_3 {

    // Print "Einmaleins"
    final static int MAX_SIZE = 10;

    public static void einmalEins() {
        for (int i = 1; i < MAX_SIZE; i++) {
            for (int j = 1; j <= MAX_SIZE; j++) {
                int erg = i * j;
                System.out.println(j + " x " + i + " = " + erg);
            }
            System.out.println("-----------------------------------");
        }
    }

    // Check if Number is Prime
    public static boolean isPrime(int number) {

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Check if String is Palindrome with toLower and Trim ( not using str == str.reverse :) )
    public static boolean isPalindrom(String word) {

        char[] chars = word.toLowerCase().trim().toCharArray();
        int len = chars.length - 1;

        for (int i = 0, j = len; j >= i; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}

