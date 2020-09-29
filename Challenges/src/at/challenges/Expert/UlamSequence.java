package at.challenges.Expert;

import java.util.ArrayList;
import java.util.List;

/*
as there is O(n^3) we have to set a max value // or maybe there is a better algorithm :)
 */

public class UlamSequence {

    final static int MAX_SIZE = 1011;
    final static int ACCEPTED_LENGTH = 12500;

    public static int getUlam(int max) {
        List<Integer> ulams;

        if (max > MAX_SIZE) {
            // print Warning
            ulams = generateUlams(50000);
        } else {
            ulams = generateUlams(ACCEPTED_LENGTH);
        }
        return ulams.get(max - 1);
    }

    private static List<Integer> generateUlams(int max) {

        var ulams = new ArrayList<Integer>();
        ulams.add(1);
        ulams.add(2);

        for (int i = 3; i < max; i++) {
            var counter = 0;
            for (int j = 0; j < ulams.size() - 1; j++) {
                for (int k = j + 1; k < ulams.size(); k++) {
                    if (ulams.get(j) + ulams.get(k) == i) {
                        counter++;
                    }
                    if (counter > 1) {
                        break;
                    }
                }
                if (counter > 1) {
                    break;
                }
            }
            if (counter == 1) {
                ulams.add(i);
            }
        }
        return ulams;
    }
}
