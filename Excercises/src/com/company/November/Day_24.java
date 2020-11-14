package com.company.November;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Day_24 {

    public static List<String> getExcelFromFile(String path, int colCount, String separator) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));
        var len = lines.size();
        List cleanList = new ArrayList();

        for (int i = 0; i < len; i++) {
            boolean isValidLine = lines.get(i) != null && !lines.get(i).isEmpty();
            var cleanLine = lines.get(i).replaceAll(" {1,}", "");

            boolean isValidInput = isValidInput(cleanLine, colCount, separator, 0, 1);
            if (!isValidLine || !isValidInput) {
                System.out.println("error on line " + i);
            }
            if (isValidLine && isValidInput) {
                cleanList.add(cleanLine);
            }
        }
        return cleanList;
    }

    public static boolean isValidInputAdvanced(String path, String separator) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));
        var len = lines.size();
        var sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            String line = lines.get(i);
            if (line.isEmpty() || line == null) {
                sb.append("Empty or null on line: " + i).append(System.getProperty("line.separator"));
                continue;
            }
            if (line.split(",").length < 2) {
                sb.append("Empty or null on line: " + i).append(System.getProperty("line.separator"));
                continue;
            }
            var cols = lines.get(i).split(separator);
            for (int j = 0; j < cols.length; j++) {
                if (hasDigit(cols[0]) || !hasDigit(cols[1])) {
                    sb.append(" wrong input in row: " + i + " col " + j).append(System.getProperty("line.separator"));
                }
            }
        }
        if (sb.length() > 0) {
            Files.createFile(Path.of("C:\\dev" +File.separator+ "Error"));
            Files.write(Path.of("C:\\dev" +File.separator+ "Error"), sb.toString().getBytes(), StandardOpenOption.APPEND);
        }

        return true;
    }

    private static boolean isValidInput(String line, int colCount, String separator, int... colsToCheck) {
        var lines = line.split(separator);

        if (lines.length < colCount || lines[0].isEmpty() || lines[1].isEmpty()) {
            return false;
        }
        if (colsToCheck.length > 0) {
            if (hasDigit(lines[colsToCheck[0]])) {
                return false;
            }
            if (!hasDigit(lines[colsToCheck[1]])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNull(String str) {
        return (str == null) ? true : false;
    }

    private static boolean isEmpty(String str) {
        return (str.isEmpty()) ? true : false;
    }

    private static boolean hasDigit(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (pattern.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    private static boolean hasNoDigit(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (pattern.matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static String[] createUniqueArray(String[] arr) {
        String[] bigger = new String[0];

        for (String a : arr) {
            if (hasValue(bigger, a)) {
                continue;
            } else {
                int len = bigger.length;
                bigger = new String[len + 1];

                for (int i = 0; i < len; i++) {
                    bigger[i] = arr[i];
                }
                bigger[len] = a;
            }
        }
        return bigger;
    }

    private static boolean hasValue(String[] arr, String str) {

        if (arr.length < 1) {
            return false;
        }
        for (String a : arr) {
            if (a.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
