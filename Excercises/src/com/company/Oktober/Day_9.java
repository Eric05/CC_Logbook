package com.company.Oktober;

/*
- Repetition Bubblesort
- Schoolclass / advanced sorting with lambda
    -> sort name by length and then by alpha ( and return only by name.length % 2 == 0 :) )
- Filter by more properties with "anyMatch" (t -> t.getPlayers().stream().anyMatch(p->p.number==playerNumber)

- compare Method
     private static int compare(String  a, String  b) {
        return a.compareTo(b) < 0 ? -1
                : a.compareTo(b) > 0 ? 1
                : 0;
    }
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day_9 {

    // Filter by more properties with "anyMatch"  ( t -> t.getPlayers().stream().anyMatch(p->p.number==playerNumber)
    public static List<String> filterNums(List<String> nums) {

        Collections.sort(nums, Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        // reverse order
        Collections.sort(nums, Collections.reverseOrder());

        nums = nums.stream().filter(s -> s.length() % 2 == 0).collect(Collectors.toList());

        return nums;
    }


    /*** play with recursion :)
     *
     * @param text
     * @param max
     * @param sum
     */
    public static void rec( String text, int max, int sum){

        System.out.println(text + max + " " + sum);

        if ( max <= 0){
            return;
        }
        sum *= max ;
        rec(text, max-1, sum);

        System.out.println(text + max + " " + sum);
    }
}
