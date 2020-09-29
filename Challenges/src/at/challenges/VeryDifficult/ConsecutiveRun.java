package at.challenges.VeryDifficult;

public class ConsecutiveRun {

    public static int longestRun(int[] numbers) {
        var max = 0;
        var counter = 1;
        var len = numbers.length;

        for (int i = 0; i + 1 < len; i++) {
            if (numbers[i] + 1 == numbers[i + 1] || numbers[i] - 1 == numbers[i + 1]) {
                counter++;
            } else {
                max = Math.max(counter, max);
                counter = 1;
            }
        }
        return Math.max(counter, max);
    }
}
/*
edge case: 1 2 3 2 1 2 3 4 3. if nums change direction consecutivly all of them are counted
 */