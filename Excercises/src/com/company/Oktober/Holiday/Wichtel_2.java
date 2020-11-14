package com.company.Oktober.Holiday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Wichtel_2 {

    private static Random r = new Random();

    public static void createWichtel(int[] arr) {
        var shuffeld = Arrays.copyOf(arr, arr.length);
        mixNames(shuffeld);

        while (!isFair(arr, shuffeld)) {
            mixNames(shuffeld);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(shuffeld));
    }

    public static boolean isFair(int[] names, int[] shuffeld) {

        var set = new HashSet<>();

        for (var s : shuffeld) {
            if (set.add(s) == false) {
                return false;
            }
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i] == shuffeld[i]) {
                return false;
            }
        }
        return true;
    }

    public static void mixNames(int[] shuffeld) {
        int len = shuffeld.length;
        int firstPos = r.nextInt(len);
        int secondPos = r.nextInt(len);

        var tmp = shuffeld[firstPos];
        shuffeld[firstPos] = shuffeld[secondPos];
        shuffeld[secondPos] = tmp;
    }
}
