package com.company;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static <T> void main(String[] args) throws IOException {

        var dir = Paths.get(System.getProperty("user.dir"));
        var path = dir.resolve("Persons");

        var walk = Files.walk(path, 5);
        var  fi = new File(String.valueOf(dir));
        var li = fi.list();
        Arrays.stream(li).forEach(System.out::println);


        var file = Paths.get(String.valueOf(path.resolve("List.txt")));
        Files.write(file, ("Hello Person"+ System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

        var lines = Files.lines(path.resolve("List.txt")).collect(Collectors.toList());

        if (Files.exists(path)){
            var atr = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(atr.creationTime().toString() + " " + atr.size()) ;
        }

        String s = null;
        System.out.println(s.isBlank());

        List<String> lineList = Arrays.asList(new String[]{"A;200", "B;122", "A;120", "B;40"});

        Map<String,Integer> map = lines.stream()
                .map(entry -> entry.split(";"))
                .collect(Collectors.groupingBy(entry -> entry[0],
                        Collectors.summingInt(entry -> Integer.parseInt(entry[1]))));

        List<Integer> values = new ArrayList(map.values());
        values.sort(Comparator.comparingInt(a-> (int) a).reversed());

        int num1 = 34;
        int num2 = 34;

        int x;

        // Creating a List of Integers 
        List<Integer> lis = Arrays.asList(3, 5, 7, 9, 11);

        // Using Stream findFirst() 
        Optional<Integer> answer = lis.stream().findFirst();

        // if the stream is empty, an empty 
        // Optional is returned. 
        if (answer.isPresent()) {
            x = answer.get();
            System.out.println(((Object)x).getClass().getName() );
        }
        else {
            System.out.println("no value");
        }
        
        Vector<Integer> nums = new Vector<>();
        nums.add(2);
        nums.add(5);
        nums.add(4);
        int counter = nums.size();

        while (counter-- > 0){
            System.out.println(nums.get(counter));
        }
        Collections.sort(nums);
        Collections.reverse(nums);
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

    private static List<Object> flat2(Object[] arr, List<Object> list) {

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












