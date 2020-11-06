package com.company.November;

import java.util.Arrays;

public class Wiederholung {

                /*
    1: teenSum - Boolean
    Gegeben sind 2 ints a und b. Geben Sie ihre Summe zurück.
    "Teen" - Werte im Bereich von 13 bis 19 sind jedoch besonders.
    Wenn einer der beiden Werte ein Teenager ist, geben Sie einfach 19 zurück.
    teenSum(3, 4) → 7 // teenSum(10, 13) → 19

    2: noFirstLast - Strings
    Geben Sie bei einer gegebenen Zeichenfolge eine Version ohne das erste und letzte Zeichen zurück,
    sodass "Hallo" -> "all" ergibt.

    3: swapEnds - Arrays)
    Tauschen Sie das 1. und das letzte Element eines Arrays von ints.
    [1,2,3,4] -> [4,2,3,1]
    */


    public static void main(String[] args) {

        // 1.)
        int sum = teenSum(13, 8);
        System.out.println(sum);

        // 2.)
        String without = withoutEnd("Hallo");
        System.out.println(without);

        // 3.)
        int[] nums = swapEnds(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(nums));
    }


    // 1.)
    public static int teenSum(int a, int b) {

        if (a >= 13 && a <= 19) {  // wenn a ein teen ist -> 19 zurückgeben
            return 19;
        }
        if (b >= 13 && b <= 19) { // wenn b ein teen ist -> 19 zurückgeben
            return 19;
        }
        return (a + b); // wenn keiner ein teen ist -> die Summe zuückgeben
    }

    // 2.) 1.Möglichkeit: mit substring erhält man den gewünschte Teil eines Strings...
    //      ... hier wird am Anfang der erste Buchstabe und am Ende der letzte entfernt
    public static String withoutEnd(String str) {

        return str.substring(1, str.length() - 1);
    }

    // 2.) 2.Möglichkeit
    public static String withoutEnd_(String str) {

        String without = ""; // leeren String initialisieren

        char[] chars = str.toCharArray(); // den String in ein Array von einzelnen Zeichen konvertieren

        for (int i = 1; i < str.length() - 1; i++) {
            without += str.charAt(i); // die einzelnen Zeichen zum leeren String hinzufügen -> aber ohne den ersten bzw. letzten
        }
        return without; // den neuen String zurückgeben
    }

    // 3.)
    public static int[] swapEnds(int[] nums) {

        int posFirst = 0; // die erste Position ist immer 0
        int posLast = nums.length - 1; // die letzte Position ist immer Länge -1, da der Index bei 0 beginnt.

        int tmp = nums[posFirst];
        nums[posFirst] = nums[posLast];
        nums[posLast] = tmp;

        return nums;
    }
}
