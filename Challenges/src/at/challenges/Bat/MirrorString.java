package at.challenges.Bat;

public class MirrorString {

    public static int getMirror(String str) {
        double half = str.length() / 2d;
        int rounded = (int) Math.ceil(half);
        int counter = 0;
        int i, j;

        if (str.length() % 2 != 0) {
            i = rounded;
            j = rounded + 1;
        } else {
            i = rounded - 1;
            j = rounded + 1;
        }
        for (; i >= 0; i--, j++) {
            if (str.charAt(i) != str.charAt(j)) {
                return counter;
            } else {
                counter++;
            }
        }
        return counter;
    }
}