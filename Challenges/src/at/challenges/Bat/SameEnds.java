package at.challenges.Bat;

public class SameEnds {

    public static String getSameEnds(String str) {

        int len = str.length();
        int half = len / 2;
        int rightIndex;

        if (len % 2 != 0) {
            rightIndex = half + 1;
        } else {
            rightIndex = half;
        }

        for (int i = 0, j = half + 1; i < len; i++) {
            String left = str.substring(0, half - i);
            String right = str.substring(rightIndex + i);

            if (left.equals(right)) {
                return left;
            }
        }
        return "";
    }
}
