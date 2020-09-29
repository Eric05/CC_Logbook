package at.challenges.Expert;

public class PalindromeDesc {

    public static boolean palindromeDescendant(Integer num) {

        if (num < 10) {
            return false;
        }
        if (isPalindrome(num)) {
            return true;
        }
        return palindromeDescendant(createNextNumber(num));
    }

    private static boolean isPalindrome(Integer num) {
        var sb = new StringBuilder();
        var word = num.toString();
        var reversedWord = sb.append(word).reverse();

        return word.equals(reversedWord.toString());
    }

    private static Integer createNextNumber(Integer num) {
        var str = Integer.toString(num);
        var nums = new int[str.length()];
        var len = str.length();
        var sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            nums[i] = str.charAt(i) - '0';
        }
        for (int i = 0; i < len; i += 2) {
            var erg = (i < len - 1) ? nums[i] + nums[i + 1] : nums[i];
            sb.append(erg);
        }
        return Integer.parseInt(sb.toString());
    }
}
