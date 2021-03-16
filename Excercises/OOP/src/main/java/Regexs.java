import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/***
 * most use cases from Hesse Example
 */
public class Regexs {

    public static void main(String[] args) {

 // (?i) -> case insensitive
    }

    public static String DeleteSilentH(String str) {
        var txt = str.replaceAll("h([mnlrz])", "$1");
        return txt;
    }

    public static boolean checkIban(String s) {
        Pattern p = Pattern.compile("AT[0-9]{2}([ -][0-9]{4}){4}");
        Matcher m = p.matcher(s);
        boolean isValidIban = m.matches();

        return isValidIban;
    }

    public static int replaceOneOrMoreWhitespace(String s) {
        String noSpace = s.replaceAll("\\s{1,}", "");

        return noSpace.length();
    }

    public static boolean isDigit(String s) {
        Pattern isDigit = Pattern.compile("-?\\d+(\\.\\d+)?");

        return s.matches(String.valueOf(isDigit));
    }

    // Helper Methods
    private boolean isOnlyUpperOrLower(String word) {

        Pattern isUpper = Pattern.compile(".*[A-Z].*");
        Pattern isLower = Pattern.compile(".*[a-z].*");
        Matcher mLower = isLower.matcher(word);
        Matcher mUpper = isUpper.matcher(word);

        if (mLower.matches() && !mUpper.matches()) {
            return true;
        }
        return !mLower.matches() && mUpper.matches();
    }

    private String generateCleanString(String text) {

        var noLinebreaks = text.replaceAll("\\\\n", "");
        var noSpecialChars = noLinebreaks.replaceAll("[.,;:?!+\"\\\\]", "");
        var trimmed = noSpecialChars.replaceAll("\\s{2,}", " ").trim();

        return trimmed;
    }

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
