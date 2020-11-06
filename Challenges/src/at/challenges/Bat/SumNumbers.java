package at.challenges.Bat;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumNumbers {
    public static int sumNumbers(String str) {

        List<String> list = new ArrayList<>();
        int erg = 0;
        String tmp = "";

        for (int i = 0; i < str.length(); i++) {
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                tmp += str.charAt(i);
                i++;
            }
            if (tmp != "") {
                list.add(tmp);
            }
            tmp = "";
        }
        for (String s : list) {
            erg += Integer.parseInt(s);
        }
        return erg;
    }

    public static int sumRegex(String str){
        int sum = 0;
        var matchers = new ArrayList<>();

        Pattern p = Pattern.compile("[0-9]+|-[0-9]+");
        Matcher m = p.matcher("There are more than -2 and less than 12 numbers here");

        while (m.find()) {
            matchers.add(m.group());
        }
        for (var matcher : matchers) {
            sum += Integer.valueOf(matcher.toString());
        }
        return sum;
    }
}
