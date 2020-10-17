package com.company.Oktober;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/***
 * get number of dots in one line :)
 * sum all digits in string
 * replace capital letter in string with 'space + capital letter'
 * normalize string
 */

public class Day_13 {

    public static int splitOneLine(String str) {
        return (str.charAt(str.length() - 1) == '.') ? str.split("\\.").length : str.split("\\.").length - 1;
    }

    public static int getNumberOfChar(String str) {
        Pattern pat = Pattern.compile("\\.");
        String[] matches = pat
                .matcher(str)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);

        return matches.length;
    }

    public static int sumNumbers(String str) {

        int erg = 0;

        String[] matches = Pattern.compile("[0-9]+")
                .matcher(str)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        // or .collect(Collectors.toList())

        for (String match : matches) {
            erg += Integer.valueOf(match);

        }
        return erg;
    }

    public static String addSpaceToCapitalLetter(String str) {
        var res = str.replaceAll("([A-Z])", " $1");

        return res;
    }

    public static String normalize(String text, String pat) {

        var noLinebreaks = text.replaceAll("\\\\n", "");
        var clean = noLinebreaks.replaceAll(pat, "");
        var trimmed = clean.replaceAll("\\s{2,}", " ").trim();

        return trimmed;
    }
    public static String normalize(String text) {

        var noLinebreaks = text.replaceAll("\\\\n", "");
        var clean = noLinebreaks.replaceAll("[^ a-zA-Z0-9ßüäöÄÖÜ-]", "");
        var trimmed = clean.replaceAll("\\s{2,}", " ").trim();

        return trimmed;
    }
}
