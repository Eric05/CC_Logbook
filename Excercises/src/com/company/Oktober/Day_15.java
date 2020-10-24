package com.company.Oktober;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/***
 * get funny Random String
 */
public class Day_15 {

    public static String getRandomString() {
        StringBuilder sb = new StringBuilder();
        var strings = getBasicLists();

        for (var s : strings) {
            int len = s.size() - 1;
            int index = getRandomIndex(0, len);
            sb.append(s.get(index) + " ");
        }
        return sb.toString();
    }

    public static String getRandomString(List<List> list) {
        StringBuilder sb = new StringBuilder();

        for (var s : list) {
            int len = s.size() - 1;
            int index = getRandomIndex(0, len);
            sb.append(s.get(index) + " ");
        }
        return sb.toString();
    }

    private static List<List> getBasicLists() {
        List<List> lists = new ArrayList<>();

        List<String> FirstAdjectives = Arrays.asList(new String[]{"Old", "Wise", "Happy", "Nice"});
        List<String> SecondAdjectives = Arrays.asList(new String[]{"Green", "Blue", "Red"});
        List<String> MainWords = Arrays.asList(new String[]{"Lion", "Eagle", "Dog","Dragon", "Crow"});

        lists.add(FirstAdjectives);
        lists.add(SecondAdjectives);
        lists.add(MainWords);

        return lists;
    }

    private static int getRandomIndex(int min, int max) {
        var rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}

