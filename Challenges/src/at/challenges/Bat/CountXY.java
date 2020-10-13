package at.challenges.Bat;

import java.util.Arrays;
import java.util.HashSet;

public class CountXY {

    // easy way using java methods
    public static int countYZ(String str) {
        int counter = 0;
        String[] strings = str.split(" ");

        for (var s : strings) {
            if (s.toLowerCase().endsWith("z") || s.toLowerCase().endsWith("y")) {
                counter++;
            }
        }
        return counter;
    }

    //  O(n) guaranteed
    public static int countYZ(String str, boolean quick) {
        char delim = ' ';
        int counter = 0;
        HashSet<Character> allowed = new HashSet<>(Arrays.asList('z', 'y'));

        for (int i = 0; i < str.length(); i++) {

            if (str.length() - 1 == i && allowed.contains(str.charAt(i)) ||
                    (str.charAt(i) == delim && allowed.contains(str.charAt(i - 1)))) {
                counter++;
            }
        }
        return counter;
    }
}
