package at.challenges.Expert;

import java.util.*;

public class StringCleaver {

    private final static List list = Arrays.asList("about", "be", "hell", "if", "is", "it", "me", "other", "outer", "people", "the", "to", "up", "where");
    private static Set<String> allowed = new HashSet<>(list);

    public static String cleave(String str) {
        var formatted = str;

        for (var a : allowed) {
            if (str.contains(a)) {
                formatted = formatted.replace(a, a + " ");
                str = str.replace(a, "");
            }
        }
        return (str.length() > 0) ? "not valid" : formatted;
    }
}
