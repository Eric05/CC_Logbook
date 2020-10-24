package com.company.Oktober;

import java.io.File;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;

/***
 * Random
 * slow and basic and not very good OWN algorithm to create Random number :)
 * manipulating seed with hashCode of last modified file ( only for windows / need to catch errors)
 * check Random by generating list with occurences
 */

public class Day_16_Random {

    public static long generateRandom(int max) throws UnknownHostException, InterruptedException {
        Thread.sleep(0, 3);

        var localMachine = java.net.InetAddress.getLocalHost().hashCode();
        var user = System.getProperty("user.name");
        var lastModified = getLastModified(System.getProperty("user.dir")).hashCode();
        var currentTime = LocalDateTime.now();

        long hour = currentTime.getHour();
        long minute = currentTime.getMinute();
        long second = currentTime.getSecond();
        long nanosecond = currentTime.getNano();

        long seed = Math.abs(Math.abs(lastModified) * Math.abs(localMachine));
        long bd = (hour + 1) * (minute + 1) * (second + 1) * nanosecond / seed;

        long randNum = Math.abs(bd) % max;

        return randNum;
    }

    public static File getLastModified(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File last = null;

        if (files != null) {
            for (var file : files) {
                if (file.lastModified() > lastModifiedTime) {
                    last = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        return last;
    }

    public static Map<Integer, Integer> checkRandom(int max) throws InterruptedException, UnknownHostException {
        Map<Integer, Integer> map = new HashMap();
        Integer[] nums = new Integer[max];

        for (int i = 0; i < max; i++) {
            var val = (int) generateRandom(100);
            nums[i] = val;
        }

        List list = Arrays.asList(nums);
        Set<Integer> mySet = new HashSet<Integer>(list);

        for (var s : mySet) {
            map.put(s, Collections.frequency(list, s));
            System.out.println(s + " " + Collections.frequency(list, s));
        }
        return map;
    }

    public static String generateHash(String str) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        var hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

        var hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            var hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
