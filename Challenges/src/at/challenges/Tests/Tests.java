package at.challenges.Tests;

import at.challenges.Bat.Fibonacci;
import at.challenges.Expert.Scrambled;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Tests {

    @Test
    public void eightFibonacciTest() {
        int actual = Fibonacci.fib(8,new HashMap<>());
        int expected = 21;
        assertEquals(expected, actual);
    }
}



    

