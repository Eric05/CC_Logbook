package com.company.Oktober;

/***
 // Pascals triangle
 // Quicksort
 */

public class Day_10 {

    // Pascals triangle with memoization using cache
    public static void printTriangle(int n) {
        int[][] cache = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(getPascal(i, k, cache) + " ");
            }
            System.out.println();
        }
    }

    // Recursive function with caching
    private static int getPascal(int row, int col, int[][] cache) {

        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        if (col == 0 || row == col) {
            return 1;
        }

        int value = getPascal(row - 1, col - 1, cache) + getPascal(row - 1, col, cache);
        cache[row][col] = value;

        return value;
    }

    // Quicksort - 1. Step: sort only partition recursively
    public static void sortPartition(int arr[], int low, int high) {
        if (low < high) {
            if (arr[low] < arr[high]) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
            sortPartition(arr, low, high - 1);
            sortPartition(arr, low + 1, high);
        }
    }
}
