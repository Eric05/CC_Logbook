package at.challenges.Expert;

import java.util.*;

public class Scrambled {

    public static String[] scrambled(Character[] letters, String[] words, String mask) {
        var allowedLength = mask.length();
        var allowedWords = new ArrayList<String>();
        var allowedLetters = new HashSet<Character>(Arrays.asList(letters));
        allowedLetters.add('*');

        for (var w : words) {
            if (hasLength(w, allowedLength) && hasLetters(w, allowedLetters) && hasPosition(w, mask)) {
                allowedWords.add(w);
            }
        }
        return (allowedWords.toArray(new String[0]));
    }

    private static boolean hasLength(String word, int len) {
        if (word.length() == len) {
            return true;
        }
        return false;
    }

    private static boolean hasLetters(String word, HashSet<Character> allowedLetters) {
        var chars = word.toCharArray();

        for (var c : chars) {
            if (!allowedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasPosition(String word, String mask) {
        var len = word.length();

        for (int i = 0; i < len; i++) {
            if (mask.charAt(i) == '*') {
                continue;
            } else if (word.charAt(i) != mask.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
