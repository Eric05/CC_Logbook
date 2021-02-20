package errorHandling;

import java.io.IOException;

public class ThrowExample {
    public static void main(String[] args)  {
        int res = 0;
        res += func1();
        res += func2();

        try {
            res += func3();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }


        System.out.println("Result = " + res);

        System.out.println("Program continues...");
    }


    public static int func1() {

        return 1;
    }

    public static int func2() {

        int resFromFunc1 = 0;
        resFromFunc1 = func1();


        return resFromFunc1 + 2;
    }

    public static int func3()  {

        int resFromFunc2 = func2();
        if (resFromFunc2 % 2 != 0) {
            throw new ArithmeticException("even number");
        }
        System.out.println("handled");
        return resFromFunc2 + 3;
    }

}
