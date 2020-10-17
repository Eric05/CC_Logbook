package com.company.Tests;

import com.company.Main;
import com.company.Oktober.Day_12;
import com.company.Oktober.Day_13;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SplitTest {

    @Test
    public void splitPointsInMiddleTest() throws InterruptedException {
       int actual = Day_13.splitOneLine( "ha...lo");
       int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void splitPointsAtBeginningTest() throws InterruptedException {
        int actual = Day_13.splitOneLine( " .ha.. lo");
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void splitPointsOnEndTest() throws InterruptedException {
        int actual = Day_13.splitOneLine( " .ich .bin.");
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void splitAllPointsAtBeginningTest() throws InterruptedException {
        int actual = Day_13.splitOneLine( "...a");
        int expected = 3;
        assertEquals(expected, actual);
    }
}
