package com.company;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class Main {

    public static <T> void main(String[] args) throws IOException {


           Thread t1 = new Thread( () -> new Timer().schedule(new TimerTask(){
            @Override
            public void run(){
                System.out.println("A Kiss every 5 seconds");
            }
        },0,2000));

        t1.start();


        var list = new ArrayList<Integer>();
        list.add(4);
        list.add(5);
        list.add(7);

        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        List<T> copy = (List<T>) List.copyOf(list);

        for (var o : list2) {
            if (o < 6){
                list.remove(o);
            }
        }
        var openingTime = 8;
        var closingTime = 16;
        var interval = 15;

        loopByGregorianDate(openingTime,closingTime,interval);


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

        var open  = (Calendar) now.clone();
        var close = (Calendar)now.clone();

        open.set(Calendar.HOUR_OF_DAY, openingTime);
        open.set(Calendar.MINUTE, 0);
        close.set(Calendar.HOUR_OF_DAY, closingTime);
        close.set(Calendar.MINUTE,0);

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
}












