package com.company;

import java.io.IOException;
import java.util.*;


public class Main {

    public static <T> void main(String[] args) throws IOException {

        Object[] array = {1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};

        var l = getFlatenedList(array);

        ArrayList list = new ArrayList();
        flat(array, list);


        System.out.println(Arrays.deepToString(array));

        Thread t1 = new Thread(() -> new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("A Kiss every 5 seconds");
            }
        }, 0, 2000));

        t1.start();


 /*       var list = new ArrayList<Integer>();
        list.add(4);
        list.add(5);
        list.add(7);*/

        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        List<T> copy = (List<T>) List.copyOf(list);

        for (var o : list2) {
            if (o < 6) {
                list.remove(o);
            }
        }
        var openingTime = 8;
        var closingTime = 16;
        var interval = 15;

        loopByGregorianDate(openingTime, closingTime, interval);


        String[] names = new String[]{"a", "v", "w"};

        var res = linearSearch(names, "v");
        System.out.println(res);

/*        var path = "C:\\dev\\Adresses.txt";
        File file = new File(path);
        file.createNewFile();
        Files.writeString(Path.of(path), "Hallo");*/
    }

    private static void loopByGregorianDate(int openingTime, int closingTime, int intervalByMinutes) {
        Calendar now = Calendar.getInstance();

        var open = (Calendar) now.clone();
        var close = (Calendar) now.clone();

        open.set(Calendar.HOUR_OF_DAY, openingTime);
        open.set(Calendar.MINUTE, 0);
        close.set(Calendar.HOUR_OF_DAY, closingTime);
        close.set(Calendar.MINUTE, 0);

        while (open.compareTo(close) < 0) {
            open.add(Calendar.MINUTE, intervalByMinutes);
            System.out.println(open.getTime());
        }
    }

    public static int linearSearch(String[] strings, String string) {
        int tries = 0;
        for (String str : strings) {
            tries++;
            if (str.equals(string)) {
                return tries;
            }
        }
        return -1;
    }

    public static List<Object> getFlatenedList(Object[] arr) {
        var list = new ArrayList();
        flat2(arr, list);
        return list;
    }

    public static List<Object> flat2(Object[] arr, List<Object> list) {

        for (Object o : arr) {
            if (!o.getClass().isArray()) {
                list.add(o);
                System.out.println(o);
            } else {
                flat((Object[]) o, (List<Object>) list);
            }
        }
        return list;
    }

    public static void flat(Object[] arr, List<Object> list) {
        for (Object o : arr) {
            if (!o.getClass().isArray()) {
                list.add(o);
                System.out.println(o);
            } else {
                flat((Object[]) o, list);
            }
        }
    }
}












