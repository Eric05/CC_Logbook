package at.challenges.Expert;

import java.util.HashSet;

public class PossiblePalindrome {

    public static boolean isPossiblePalindrome( String word){

        var set = new HashSet<Character>();

        for (int i = 0; i < word.length(); i++){

            if (set.contains(word.charAt(i))){
                set.remove(word.charAt(i));
            } else {
                set.add(word.charAt(i));
            }
        }
        return (set.size() <= 1);
    }
}
