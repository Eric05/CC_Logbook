package at.challenges.VeryDifficult;

public class GetOneDigit {

    public static int getOneDigit(int number){
        var added = add(number);
        var multiplied = multiply(added);

        return multiplied;
    }

    private static int add(int num){

        var chars = String.valueOf(num).toCharArray();
        var sum = 0;

        for (var c : chars){
            int val = Character.getNumericValue(c);
            sum += val;
        }
        return sum;
    }

    private static int multiply(int sum) {

        if (sum < 10) {
            return sum;
        }
        var chars = String.valueOf(sum).toCharArray();
        sum = 1;

        for (var c : chars) {
            int val = Character.getNumericValue(c);
            sum *= val;
        }
        return multiply(sum);
    }
}
