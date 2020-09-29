package at.challenges.VeryDifficult;

/*
Wikipedia Solution is pretty smart :)
 */

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidateCredit {

    public static boolean isValidCardNumber(long number) {

        var val = 0;
        var sum = 0;
        var numbers = String.valueOf(number).toCharArray();
        var len = numbers.length;

        for (var i = 0; i < len; i++) {
            val = Integer.valueOf(numbers[i]);
            if (i % 2 == 1) {
                val *= 2;
                if (val > 9) {
                    val = 1 + (val % 10);
                }
            }
            sum += val;
        }
        return sum % 10 == 0;
    }
}
