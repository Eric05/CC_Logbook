package com.company.September;

/*
- Repetition of previous Excercises
- for Loop by printing an arrow
- Sorting Algorithms
 */

import java.util.List;

public class Day_4 {

    // print Arrow with two for loops
    public static void PrintArrow() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('x');
            }
            System.out.println();
        }
        for (int i = 6; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print('x');
            }
            System.out.println();
        }
    }

    // Print Arrow with Control flow
    public static void printArrow2(int num, String ch) {
        int max = num * 2;
        int j = 0;

        for (int i = 1; i < max; i++) {
            if (i < num) {
                j = 0;
                for (; j < i; j++) {
                    System.out.print(ch);
                }
            } else {
                j = i;
                for (; j < max; j++) {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }

    // print reverse arrow recursively
    private static void printArrow_rev(int num, String ch) {

        if (num <= 0) {
            return;
        }

        for (int i = num; i > 0; i--) {
            System.out.print(ch);
        }
        System.out.println();

        printArrow_rev(num - 1, ch); // rec call

        for (int i = num; i > 0; i--) {
            System.out.print(ch);
        }
        System.out.println();
    }

    /*
    Basic sorting algorithms:
    - Here I use destructive "in place" method
    - all of them have worst Case of O ( n ^ 2)

    Base Knowledge:
    - nested loops
    - swap variables
    - shift array to left with while loop
     */

    // Selectionsort:
    public static Integer[] selectionSorted(Integer[] arr) {

        var len = arr.length - 1;

        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j <= len; j++)
                if (arr[j] < arr[min])
                    min = j;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    // Bubblesort: most efficient Implementation, breaks out if for loop runs without sorting
    public static Integer[] bubbleSorted(Integer[] arr) {

        int counter = 0;

        int len = arr.length;
        int temp = 0;
        boolean isUnsorted = true;

        while (isUnsorted) {
            for (int j = 0; j < len-1; j++) {
                isUnsorted = false;
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j] = temp;
                    isUnsorted = true;
                }

                counter++;
                System.out.println((char) 27 + "[31m" + +counter + " runs needed");
            }
        }
        return arr;
    }

    // Insertionsort:
    public static Integer[] insertionSorted(Integer arr[]) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int val = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = val;
        }
        return arr;
    }
}

// --------------------------------------------------------------
/*
Shift array to left:
   public static void shift(Integer[] arr) {

        var len = arr.length - 1;
        var tmp = arr[len];
        var j = len;

        while (j > 0) {
            arr[j] = arr[j - 1];
            j = j - 1;
        }
        arr[j] = tmp;
    }

 Shift last element as long as left element is larger
 ...
  while ( j > 0 && arr[j] > tmp )
  ...
 */