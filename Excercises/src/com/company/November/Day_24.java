package com.company.November;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class Day_24 {
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[41m";

    public static List<String> getExcel(String path, int colCount, String separator) throws IOException {
        if (!isValidInputWithLogFile(path, separator, colCount)) {
            System.out.println(ANSI_YELLOW_BACKGROUND + "errors in excel. please check errorlog");
            System.out.println("Press c to cancel g to get list without any corrupted rows");
            Scanner sc = new Scanner(System.in);
            var inp = sc.nextLine();
            if (!inp.equals("g")) {
                return null;
            }
        }
        return getExcelFromFile(path, colCount, separator);
    }

    public static List<String> getExcelFromFile(String path, int colCount, String separator) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));
        var len = lines.size();
        List cleanList = new ArrayList();

        for (int i = 0; i < len; i++) {
            boolean isValidLine = lines.get(i) != null && !lines.get(i).isEmpty();
            var cleanLine = lines.get(i).replaceAll(" {1,}", "");

            boolean isValidInput = isValidInput(cleanLine, colCount, separator, 0, 1);

            if (isValidLine && isValidInput) {
                cleanList.add(cleanLine);
            }
        }
        return cleanList;
    }

    public static boolean isValidInputWithLogFile(String path, String separator, int colNum) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));
        var len = lines.size();
        var sb = new StringBuilder();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        var dat = formatter.format(date);

        for (int i = 0; i < len; i++) {
            String line = lines.get(i);
            if (line.isEmpty() || line == null) {
                sb.append("Empty or null on line: " + (i + 1)).append(System.getProperty("line.separator"));
                continue;
            }
            if (line.split(",").length < colNum) {
                sb.append("Not enough cols in line: " + (1 + i)).append(System.getProperty("line.separator"));
                continue;
            }
            var cols = lines.get(i).split(separator);
            for (int j = 0; j < cols.length; j++) {
                if ((j == 0 && !hasNoDigit(cols[j])) || (j == 1 && !hasDigit(cols[j]))) {
                    sb.append(" wrong datatype or unexpected space in row: " + (i + 1) + " col " + j).append(System.getProperty("line.separator"));
                }
            }
        }
        if (sb.length() > 0) {
            sb.insert(0, "\n" + dat + "\nExcel contains following errors:\n");
            if (!Files.exists(Path.of("C:\\dev" + File.separator + "Error"))) {
                Files.createFile(Path.of("C:\\dev" + File.separator + "Error"));
            }
            Files.write(Path.of("C:\\dev" + File.separator + "Error"), sb.toString().getBytes(), StandardOpenOption.APPEND);
            return false;
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
        if (pattern.matcher(str).find()) {
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
