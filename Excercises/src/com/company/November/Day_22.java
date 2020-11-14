package com.company.November;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Day_22 {

    public void printSortedInfo(Map<String, Integer> map, String info) {

        var sorted = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a, b) -> b - a))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : sorted.entrySet())
            System.out.println("Name: " + entry.getKey() +
                    "-> " + info + ": " + entry.getValue());
    }

    public void printSortedInfo(Map<String, Double> map) {

        var sorted = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a, b) -> (int) (b - a)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Double> entry : sorted.entrySet())
            System.out.println("Name: " + entry.getKey() +
                    "-> Average " + ": " + Math.round(entry.getValue() * 10) / 10.0);
    }

    public void printEmployeeSum(Map<String, Integer> people) {
        var sum = people.entrySet().size();

        System.out.println("Actual number of employees: " + sum);
    }

    public static Map<String, Double> getAverage(Map<String, Integer> hours, Map<String, Integer> days) {

        return hours.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> (double) entry.getValue() / days.get(entry.getKey()))
                );
    }

    public Map<String, Integer> getDays(String[][] list) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] l : list) {
            if (map.containsKey(l[0])) {
                int days = map.get(l[0]) + 1;
                map.put(l[0], days);
            } else {
                map.put(l[0], 1);
            }
        }
        return map;
    }

    public Map<String, Integer> getMonthlyPayment(Map<String, Integer> hours, Map<String, Integer> income) {
        Map<String, Integer> month = new HashMap<>();

        for (var h : hours.entrySet()) {
            var key = h.getKey();
            var val = h.getValue() * income.get(key);
            month.put(key, val);
        }
        return month;
    }

    public Map<String, Integer> sumHoursbyLambda(String[][] arr) {

        return Arrays.stream(arr)
                .collect(Collectors.toMap(
                        entry -> entry[0],
                        entry -> Integer.parseInt(entry[1]),
                        Integer::sum
                ));
    }

    public Map<String, Integer> sumHours(String[][] list) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] l : list) {
            if (map.containsKey(l[0])) {
                int hours = map.get(l[0]) + Integer.parseInt(l[1]);
                map.put(l[0], hours);
            } else {
                map.put(l[0], Integer.valueOf(l[1]));
            }
        }
        return map;
    }

    public Map<String, Integer> getIncome(String path) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));

        return lines.stream()
                .collect(Collectors.toMap(
                        entry -> entry.split(",")[0],
                        entry -> Integer.parseInt(entry.split(",")[1]))
                );
    }

    public String[][] getExcelFromFile(String path, int colCount, String separator) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));

        var len = lines.size();
        String[][] excel = new String[len][colCount];

        for (int i = 0; i < len; i++) {
            if (lines.get(i) != null || lines.get(i).isEmpty()) {
                excel[i] = lines.get(i).split(separator);
            }
        }
        return excel;
    }

    public static String[][] readCSV(String filename, String separator) {
        Vector<String[]> content = new Vector<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while (br.ready()) {
                String line = br.readLine();
                content.add(line.split(separator));
            }
            br.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return content.toArray(String[][]::new);
    }
}

