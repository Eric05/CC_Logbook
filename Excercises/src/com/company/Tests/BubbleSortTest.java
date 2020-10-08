package com.company.Tests;

import com.company.Oktober.Day_8;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void bubbleSortedShortTest() throws InterruptedException {
        Integer[] actual = Day_8.bubbleSorted(new Integer[]{1,2,3});
        Integer[] expected = new Integer[]{1,2,3};
        assertEquals(expected, actual);
    }

    @Test
    public void bubbleReversedShortTest() throws InterruptedException {
        Integer[] actual = Day_8.bubbleSorted(new Integer[]{3,2,1});
        Integer[] expected = new Integer[]{1,2,3};
        assertEquals(expected, actual);
    }
}
