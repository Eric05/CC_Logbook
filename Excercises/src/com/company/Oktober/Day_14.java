package com.company.Oktober;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/***
 * Different Methods to sort
 * writing own comparator
 * ad example textanalysis: delete "stummes H", as it is not spoken char :)
 *  simple Algorithm: " stummes "h" meistens vor l, m, n, r, z"
 */

public class Day_14 {

    public static List<String> sortByLengthLamda(String[] strings) {
        List<String> list = Arrays.asList(strings);
        list.sort(Comparator.comparingInt(String::length));

        return list;
    }

    public static List<String> sortByAlphaLamda(String[] strings) {
        List<String> list = Arrays.asList(strings);
        // case Insensitiv - list.sort(String.CASE_INSENSITIVE_ORDER );
        list.sort(Comparator.naturalOrder());

        return list;
    }

    public static String[] sortArrayByCapital(String[] strings) {
        int n = strings.length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i -1; j++) {
                if (strings[i].compareToIgnoreCase(strings[j]) <= 0) {
                    String tmp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = tmp;
                }
            }
        return strings;
    }

    public static String[] sortArrayByLength(String[] strings) {
        int n = strings.length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (strings[i].length() <= strings[j].length()) {
                    String tmp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = tmp;
                }
            }
        return strings;
    }

    public static String DeleteSilentH(String str){
      var txt = str.replaceAll("h([m|n|l|r|z])", "$1");
      return txt;
    }

    // implementation of comparer
    static class SpecificSortingComparator implements Comparator<String> {

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
}
