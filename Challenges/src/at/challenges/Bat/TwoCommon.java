package at.challenges.Bat;

public class TwoCommon {

    public static int twoCommon(String[] a, String[] b) {

        int i = 0;
        int j = 0;
        int counter = 0;
        int len = Math.min(a.length, b.length);

        while (j <= len) {
            if (a[i] == b[j]) {
                counter++;
                i++;
                j++;
            } else if ((a[i]).compareTo(b[j]) > 0) {
                j++;
            } else {
                i++;
            }
        }
        return counter;
    }
}
