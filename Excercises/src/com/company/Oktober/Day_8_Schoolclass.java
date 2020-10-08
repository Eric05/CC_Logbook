package com.company.Oktober;

import java.util.*;

/*
Schoolclass with String methods on names
 ! use compareToIgnoreCase in getDoubledNames to ignore upper/lower in case users didnt give clean input
   use overloaded Method getNamesByLength to sort names ignoring upper/lower
 */

public class Day_8_Schoolclass {

    // private field
    private String[] pupils;

    //constructor
    public Day_8_Schoolclass(String[] pupils) {
        this.pupils = pupils;
    }

    // getter
    public String[] getPupils() {
        return pupils;
    }

    // setter
    public void setPupils(String[] pupils) {
        this.pupils = pupils;
    }

    // logic
    public int getCount() {

        return pupils.length;
    }

    public String getLongestName() {
        String max = "";

        for (String p : pupils) {
            if (p.length() > max.length()) {
                max = p;
            }
        }
        return max;
    }

    public String getShortestName() {
        String min = pupils[0];

        for (String p : pupils) {
            if (p.length() < min.length()) {
                min = p;
            }
        }
        return min;
    }

    public String[] getNamesByLength(boolean caseSenstiv) {
        String[] namesByLength = new String[2];
        String[] sortedArray = Arrays.copyOfRange(pupils, 0, pupils.length - 1);
        int counter = 0;

        List<String> sortedList = Arrays.asList(sortedArray);
        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

        for (String l : sortedList) {
            sortedArray[counter] = l;
            counter++;
        }

        namesByLength[0] = sortedArray[0];
        namesByLength[1] = sortedArray[sortedArray.length - 1];

        return namesByLength;
    }

    public String[] getNamesByLength() {
        String[] namesByLength = new String[2];
        String[] sorted = Arrays.copyOfRange(pupils, 0, pupils.length - 1);

        Arrays.sort(sorted);
        namesByLength[0] = sorted[0];
        namesByLength[1] = sorted[sorted.length - 1];

        return namesByLength;
    }

    public List<String> getDoubledNames() {
        List<String> doubles = new ArrayList<>();

        for (int i = 0; i < pupils.length; i++) {
            for (int j = i; j < pupils.length - 1; j++) {
                if (pupils[i].compareToIgnoreCase(pupils[j + 1]) == 0) {
                    doubles.add(pupils[i]);
                }
            }
        }
        return doubles;
    }

    // ! case sensitive compares to Asci Value
    public String sortNamesByAlpha() {
        String[] namesByLength = new String[2];
        String[] sorted = Arrays.copyOfRange(pupils, 0, pupils.length - 1);

        Arrays.sort(sorted);

        return Arrays.toString(sorted);
    }

    /***
     * @return
     */
    public String sortNamesByLengthandAlpha() {

        List<String> list = Arrays.asList(pupils);
        Collections.sort(list,
                Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        String[] sorted = list.toArray(new String[0]);

        return Arrays.toString(sorted);
    }

   // compare Method
     private static int compare(String  a, String  b) {
        return a.compareTo(b) < 0 ? -1
                : a.compareTo(b) > 0 ? 1
                : 0;
    }

    // View
    public static void printInfo(String[] pupils) {

        Day_8_Schoolclass sc = new Day_8_Schoolclass(pupils);

        System.out.println(sc.getCount());
        System.out.println(sc.getLongestName());
        System.out.println(sc.getShortestName());
        System.out.println(sc.getNamesByLength(true)[0]);
        System.out.println(sc.getNamesByLength(true)[1]);

        System.out.println(Arrays.toString(sc.getDoubledNames().toArray()));
        System.out.println(sc.sortNamesByAlpha());
        System.out.println(sc.sortNamesByLengthandAlpha());
    }
}
