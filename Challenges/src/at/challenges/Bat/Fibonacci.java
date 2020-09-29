package at.challenges.Bat;

import java.util.HashMap;
import java.util.HashSet;

public class Fibonacci {

    public static int fib(int n) {

        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

        if (n < 1 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = fib(n - 1) + fib(n - 2);

        memo.put(n, res);

        return res;
    }
}
