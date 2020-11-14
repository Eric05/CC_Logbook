package at.challenges.Bat;

import java.util.Arrays;
import java.util.HashMap;

public class AllSwap {
    public static String[] allSwap(String[] strings) {

        String[] copy = Arrays.copyOf(strings, strings.length);
        HashMap<String, Integer> positions = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String key = strings[i].substring(0, 1);

            if (positions.containsKey(key)) {
                swap(copy, i, positions.get(key));
                positions.remove(key);
            } else {
                positions.put(key, i);
            }
        }
        return copy;
    }

    private static <T> void swap(T[] arr, int pos1, int pos2) {
        T tmp = arr[pos1];
        arr[pos2] = arr[pos1];
        arr[pos1] = tmp;
    }
}
