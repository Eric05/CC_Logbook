package at.challenges.VeryDifficult;

import java.lang.reflect.Array;

public class DifferenceCipher {

    public static int[] encrypt(String message) {
        int len = message.length();
        char[] charArr = message.toCharArray();
        int[] res = new int[len];

        res[0] = Integer.valueOf(charArr[0]);

        for (int i = 0; i < charArr.length - 1; i++) {
            int num1 = Integer.valueOf(charArr[i]);
            int num2 = Integer.valueOf(charArr[i + 1]);
            int difference = num2 - num1;

            res[i + 1] = difference;
        }
        return res;
    }

    public static String decrypt(int[] encMessage) {
        char first = (char) encMessage[0];
        String res = "";
        int numValue = 0;

        for (int i = 0; i < encMessage.length - 1; i++) {
            numValue += encMessage[i];
            char ch = (char) (numValue);
            res += ch;
        }
        return res;
    }
}
