package at.challenges.VeryDifficult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelFamily {

    public static List<String> sameVowelGroup(String[] arr) {

        List<String> res = new ArrayList<>();

        var set = getVowelsFromFirst(arr[0]);

        for (var a : arr) {
            if (hasLetter(a, set)) {
                res.add(a);
            }
        }
        return res;
    }

    private static HashSet<String> getVowelsFromFirst(String first) {
        HashSet<String> allMatches = new HashSet<>();
        Matcher m = Pattern.compile("[aeiou]").matcher(first);
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches;
    }

    private static HashSet<String> getVowels(String first) {
        HashSet<String> allMatches = new HashSet<>();
        Matcher m = Pattern.compile("[aeiou]").matcher(first);
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches;
    }

    private static boolean hasLetter(String str, HashSet<String> expected) {

        var set = getVowels(str);

        if (expected.size() > set.size()) {
            return false;
        }
        for (var s : set) {
            if (!expected.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
