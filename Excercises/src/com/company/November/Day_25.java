package com.company.November;

/*      Einlesen der CSV Daten als zweidimensionales String Array
        irrelevante Einträge (Überschriften, voranschlag-rj=0) markieren/ignorieren oder löschen
        Gesamtbudget 2019 (Summe aller Einzelposten)
        Top 10 der größten Einzelposten
        Top 10 der kleinsten Einzelposten
        Ausgaben für Schulen (Volksschulen, Mittelschulen, Poly) - ansatzbezeichnung enthält "Volksschule", "Mittelschule", "Polytechnische"
        Anteil Ausgaben für Schulen  in % am Gesamtbudget
        Ausgaben für Kindergärten - ansatzbezeichnung enthält "Kindergarten", "Ganztagskindergarten"
        Anteil Ausgaben für Kindergärten in % am Gesamtbudget*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class Day_25 {

    // read csv as list
    public List<String> getListFromCsvFile(String path) throws IOException {

        return Files.readAllLines(Path.of(path));
    }

    // skip header line and returns 2d Array
    public String[][] createExcelWithoutHeader(List<String> lines, String separator) {

        lines = lines.stream().skip(1).collect(Collectors.toList());
        var len = lines.size();
        String[][] excel = new String[lines.size()][];

        for (int i = 0; i < len; i++) {
            if (lines.get(i) != null || lines.get(i).isEmpty()) {
                excel[i] = lines.get(i).split(separator);
            }
        }
        return excel;
    }

    // print and calculate total budget
    public void printTotal(long total) {
        System.out.printf("Total Budget was: %,d\n", total);
    }

    public long getTotalBudget(String[][] excel, int col) {
        long total = 0;

        for (String[] strings : excel) {
            double money = 0;
            try {
                money = Long.parseLong(strings[col]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            total += money;
        }
        return total;
    }

    /**
     * Print ten highest and ten lowest using private helper Method to sort array by column
     *
     * @param excel      2dArray
     * @param max        size of lines to read
     * @param zeroBudget skips zero values in budget
     */
    public void printTenLowest(String[][] excel, int max, boolean zeroBudget) {
        var sorted = sortByColValue(excel, 2);
        int index = 0;

        if (zeroBudget) {
            System.out.println("\tten lowest budgets: ");
            for (int i = 0; i < max; i++) {
                System.out.println("ten lowest: ");
                System.out.println(sorted[i][0] + " : " + sorted[i][2]);
            }
        } else {
            while (sorted[index][2].equals("0")) {
                index++;
            }
            System.out.println("Ten lowest budgets without zero: ");
            for (int i = index; i < (index + max); i++) {
                System.out.println("\t" + sorted[i][0] + " : " + sorted[i][2]);
            }
        }
    }

    public void printTenHighest(String[][] excel, int max) {
        var sorted = sortByColValue(excel, 2);
        var len = sorted.length - 1;

        System.out.println("Ten higest budgets: ");
        for (int i = len; i > len - max; i--) {
            System.out.printf("\t" + sorted[i][0] + ": %,d\n", Long.valueOf(sorted[i][2]));
        }
    }

    private String[][] sortByColValue(String[][] excel, int col) {
        String[][] copy = Arrays.copyOf(excel, excel.length);

        Arrays.sort(copy, Comparator.comparingLong(a -> Long.parseLong(a[col])));

        return copy;
    }
    // end of highest / lowest ------------------------------------------------------------------------------


    // Ausgaben für Schulen (Volksschulen, Mittelschulen, Poly)
    public void printSchoolBudget(String[][] excel, String[] fields) {
        long budget = getBudgetByFields(excel, fields);
        var sb = new StringBuilder();
        for (var f : fields) {
            sb.append(f).append(",");
        }
        sb.setLength(sb.length() - 1);
        System.out.printf("Budget for " + sb.toString() + ": %,d\n", budget);
    }

    public long getBudgetByFields(String[][] excel, String[] fields) {
        int len = excel.length;
        long budget = 0;
        for (int i = 0; i < len; i++) {
            for (String field : fields) {
                if (excel[i][0].startsWith(field)) {
                    budget += Long.parseLong(excel[i][2]);
                }
            }
        }
        return budget;
    }

    // percentage
    public void printPercentage(long sum, long field, String msg) {
        double res = (double) field / sum * 100;
        double clean = (double) Math.round(res * 10) / 10;
        System.out.println("Percentage for " + msg + " : " + clean);
    }

    // Ausgaben für Kindergärten
    public void printChildrenBudget(String[][] excel, String[] fields) {
        long budget = getBudgetByFields(excel, fields);
        var sb = new StringBuilder();
        for (var f : fields) {
            sb.append(f).append(",");
        }
        sb.setLength(sb.length() - 1);
        System.out.printf("Budget for " + sb.toString() + ": %,d\n", budget);
    }

    // Create map with budget and a list of all the fields with same budget
    public Map<Long, List<String>> groupByBudget(String[][] excel, int colOne, int colTwo) {
        Map<Long, List<String>> budgetGroups = new HashMap<>();

        for (String[] strings : excel) {
            Long key = Long.valueOf(strings[colTwo]);
            String val = strings[colOne];
            List<String> list;

            if (budgetGroups.containsKey(key)) {
                list = budgetGroups.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(val);
            budgetGroups.put(key, list);
        }
        return budgetGroups;
    }

    // sort budget group and skip zero budgets
    // sort reverse : .sorted((f1, f2) -> Long.compare(f2.getKey(), f1.getKey()))
    public Map<Long, List<String>> sortBudgetGroupsFilterZero(Map<Long, List<String>> budgetGroups) {

        return budgetGroups
                .entrySet()
                .stream()
                .filter((e) -> e.getKey() != 0)
                .sorted(Comparator.comparingLong(Map.Entry::getKey))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    /**
     * get the x max/min elements in O(n)
     *
     * @param excel
     * @param size  of elements
     * @param top   or min
     * @return
     */
    public static Long[] getEnds(String[][] excel, int size, boolean top) {
        Long[] topArray = new Long[size];
        int i;

        if (top) {
            Arrays.fill(topArray, Long.MIN_VALUE);
            for (i = 0; i < excel.length; i++) {
                Long actual = Long.parseLong(excel[i][2]);
                if (topArray[0] < actual) {
                    insertElem(topArray, actual, 0);
                }
            }
        } else {
            Arrays.fill(topArray, Long.MAX_VALUE);
            for (i = 0; i < excel.length; i++) {
                Long actual = Long.parseLong(excel[i][2]);
                if (topArray[size - 1] > actual) {
                    insertElem(topArray, actual, size - 1);
                }
            }
        }
        return topArray;
    }

    /**
     * swaps new element with element on edge position then does insertionsort
     *
     * @param arr
     * @param elem
     * @param edgePosition : element[0] is swapped with new - if min element[size-1]
     * @return
     */
    private static Long[] insertElem(Long[] arr, Long elem, int edgePosition) {
        arr[edgePosition] = elem;
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            Long val = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = val;
        }
        return arr;
    }
}
