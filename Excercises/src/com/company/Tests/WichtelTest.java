package com.company.Tests;

import com.company.Oktober.Holiday.Christmas;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class WichtelTest {

    final int MAX = 100;

    public boolean testWichtel(String[] persons, int max) {
        List<String> matches = new ArrayList<>();
        Christmas c = new Christmas();

        for (int i = 0; i < max; i++) {
            var x = c.getWichtel(persons);
            matches.addAll(x);
        }
        matches = matches.stream()
                .filter((s) -> s.split(" ")[0].equals(s.split(" ")[1]))
                .collect(Collectors.toList());

        return matches.size() == 0;
    }

    @Test
    public void onlyTwoTest() throws InterruptedException {
        Christmas c = new Christmas();
        String[] onlyTwo = {"Eric", "Dan"};
        boolean expected = testWichtel(onlyTwo, MAX);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void oddArrayTest() throws InterruptedException {
        Christmas c = new Christmas();
        String[] shortArray = {"Eric", "Lucas", "Klaus", "Dan", "Ali"};
        boolean expected = testWichtel(shortArray, MAX);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() throws InterruptedException {
        Christmas c = new Christmas();
        String[] longArray = {"Eric", "Lucas", "Klaus", "Dan", "Ali", "Marcella", "Bokhee", "Sabrina", "Samet", "Michael", "Irene", "Alex"};
        boolean expected = testWichtel(longArray, MAX);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void sameNamesTest() throws InterruptedException {
        Christmas c = new Christmas();
        String[] sameNames = {"Eric", "Lucas", "Ali", "Dan", "Ali", "Marcella", "Bokhee", "Sabrina", "Samet", "Alex", "Irene", "Alex"};
        boolean expected = testWichtel(sameNames, MAX);
        boolean actual = true;
        assertEquals(expected, actual);
    }
}
