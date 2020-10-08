package at.challenges.Bat;

import java.util.LinkedList;
import java.util.Queue;

public class Array54 {

    public static int[] array54(int[] arr) {
        Queue<Integer> indicesOfFive = new LinkedList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                indicesOfFive.add(i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                var pos = indicesOfFive.remove();
                var tmp = arr[pos];
                arr[pos] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
        return arr;
    }
}
