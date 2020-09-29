package at.challenges.Expert;

public class StepsToPalindrome {

    public static int getSteps(String word) {
        var counter = 0;
        var len = word.length();
        var sbf = new StringBuffer(word);

        for (int i = 0; i < len; i++) {
            if (isPalindrome(sbf.toString())) {
                return counter;
            }
            sbf.insert(len, word.charAt(i));
            counter++;
        }
        return counter;
    }

    private static boolean isPalindrome(String word) {
        var sb = new StringBuilder();
        var reversedWord = sb.append(word).reverse();

        return word.equals(reversedWord.toString());
    }
}
