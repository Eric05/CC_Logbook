package Comparator_Comparable;

import java.util.Comparator;

/***
 * Comparator Class with more complicated logic
 *  compare Method
 *      private static int compare(String  a, String  b) {
 *         return a.compareTo(b) < 0 ? -1
 *                 : a.compareTo(b) > 0 ? 1
 *                 : 0;
 *     }
 */

class SpecificSortingComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        String s1Converted = s1.replaceAll("[Ää]", "ae");

        if ((s1.length() < s2.length()) ||
                (s1.length() == s2.length() && s1Converted.compareTo(s1Converted) > 0))
            return -1;
        else if (s1.length() == s2.length() && s1Converted.compareTo(s1Converted) == 0)
            return 0;
        else
            return 1;
    }

    public int compare(int n1, int n2) {

        int counter = 0;

        if (n1 % 2 == 0) {
            counter++;
        } else {

            counter--;
        }
        if (n1 % 3 == 0) {
            counter += 3;
        } else if (n2 % 3 == 0) {
            counter -= 3;
        }
        if (n1 % 7 == 0) {
            counter += 7;
        } else if (n2 % 7 == 0) {
            counter -= 7;
        }
        return counter;
    }
}
