package com.company.Oktober;

import java.util.Arrays;
import java.util.Optional;

/*
Sorting Algorithms: Bubblesort repetition

 */
public class Day_8 {

    // Bubblesort optimized with output
    public static Integer[] bubbleSorted(Integer[] arr) throws InterruptedException {

        int counter = 0;
        int len = arr.length;
        int temp;
        boolean isUnsorted = true;

        while (isUnsorted) {
            isUnsorted = false;
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    isUnsorted = true;
                }
            }
            printOutput(counter++, arr);
        }
        return arr;
    }

    // Bubblesort slow with two for loops over full length with output
    public static Integer[] bubbleSorted_Slow(Integer[] arr) throws InterruptedException {
        int counter = 0;
        int len = arr.length;
        int temp;

        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j] = temp;
                }
                System.out.println(counter++ + " runs needed");
               //printOutput(counter++, arr);
            }
        return arr;
    }

    // Visual Output for bubblesort
    private static void printOutput(int counter, Integer[] arr) throws InterruptedException {
        Thread.sleep(1000);
        counter++;
        if (counter % 10 == 0){
            System.out.println();
        }
        System.out.println(counter + " runs needed\t");
        System.out.println(Arrays.toString(arr));
    }

    public static String[] bubbleSorted_Slow(String[] arr) {
        int counter = 0;
        int len = arr.length;
        String temp;

        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 1) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j] = temp;

                counter++;
                System.out.println(counter + " runs needed");
        }
      }
        return arr;
    }

    // Print info - compare sort algorithms
      // Using Varargs and if Check to simulate C# default parameters
    public static void compareBubblessorts(Integer... nums) throws InterruptedException {
         String GREEN_BOLD = "\033[1;32m";
         String WHITE = "\033[0;37m";

        if (nums.length < 1){
            nums = new Integer[]{1,2,13,8,3,7,12,9,23,27,34,45,89};
        }

        Day_8.bubbleSorted_Slow(nums);
        System.out.println(GREEN_BOLD);
        System.out.println("Optimized Sort:");
        var res = Day_8.bubbleSorted(nums);
        System.out.println(Arrays.toString(res));
        System.out.println(WHITE);
    }
}

