package at.challenges.Bat;

import java.util.ArrayList;
import java.util.List;

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
}
