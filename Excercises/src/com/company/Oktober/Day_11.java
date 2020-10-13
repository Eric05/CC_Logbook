package com.company.Oktober;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * Repetition Recursion with simpler example
 * Java String Class
 * Regex
 */

public class Day_11 {

    public static long printFactorial(int n, HashMap<Integer, Long> cache) {
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        if (n == 1) {
            return 1;
        }
        long value = n * printFactorial(n - 1, cache);
        cache.put(n, value);
        return value;
    }

    public static boolean checkIban(String s) {
        Pattern p = Pattern.compile("AT[0-9]{2}([ -][0-9]{4}){4}");
        Matcher m = p.matcher(s);
        boolean isValidIban = m.matches();

        return isValidIban;
    }
}
