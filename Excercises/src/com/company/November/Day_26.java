package com.company.November;

import java.util.*;

/**
 * Searching for n max or min elements in O(n) with Priority Queue
 * TODO Make it generic
 */
public class Day_26 {

    public static void main(String[] args) {

        Random r = new Random();
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            var num = r.nextInt(1000);
            numList.add(num);
        }
        var res = getTopElements(numList, 7);

        while (!res.isEmpty()) {
            System.out.println(res.poll());
        }
    }

    public static Queue<Integer> getTopElements(List<Integer> list, int size) {
        Queue<Integer> pk = new PriorityQueue<>(Comparator.naturalOrder());

        for (Integer actual : list) {
            Integer pkHead = pk.peek();

            if (pk.size() < size) {
                pk.add(actual);
            } else {
                if (actual > pkHead) {
                    pk.poll();
                    pk.add(actual);
                }
            }
        }
        return pk;
    }

    public static Queue<Integer> getBottomElements(List<Integer> list, int size) {
        Queue<Integer> pk = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer actual : list) {
            Integer pkHead = pk.peek();

            if (pk.size() < size) {
                pk.add(actual);
            } else {
                if (actual < pkHead) {
                    pk.poll();
                    pk.add(actual);
                }
            }
        }
        return pk;
    }
}


