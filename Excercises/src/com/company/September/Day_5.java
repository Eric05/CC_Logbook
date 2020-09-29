package com.company.September;

/*
Arrays
Buchhandel with Businessresults
 */

import java.util.Arrays;

public class Day_5 {

    public static void printArr1(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArr2(String[] arr, String separator) {
        var sb = new StringBuilder();
        for (var a : arr) {
            sb.append(a).append(separator);
        }
        var str = sb.toString();
        System.out.println('[' + str.substring(0, str.length() - separator.length()) + ']');
    }

    public static void printArr3(String[] arr) {

        var len = arr.length;

        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }


    // ----------------------------------------------------------------------------------------------------------//
    // Buchladen: not using predefined Methods

    public static int getSum(int[] arr) {
        int erg = 0;
        for (int i = 0; i < arr.length; i++) {
            erg += arr[i];
        }
        return erg;
    }

    public static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMonthWithWorstResult(int[] arr) {
        int min = 1000;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = i;
            }
        }
        return min;
    }

    public static int getMonthWithBestResult(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > i) {
                max = i;
            }
        }
        return max;
    }

    public static boolean checkForTwoNegativeMonths(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                counter++;
            }
        }
        return counter == 2;
    }

    public static int longestNegativeInterval(int[] arr) {
        int counter = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                counter++;
            } else {
                if (counter > max) {
                    max = counter;
                }
                counter = 0;
            }
        }
        return max;
    }

    public static int getSecondBestResult(int[] arr) {
        int best = getMax(arr);
        int second = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > second && arr[i] < best)
                    second = arr[i];
                }
            return second;
        }

        // most efficient way to get second element: O(n)
    public static int getSecondBestOn(int[] arr) {
        int best = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > best) {
                second = best;
                best = arr[i];
            } else if (arr[i] > second){
                second = arr[i];
            }
        }
        return second;
    }
}

