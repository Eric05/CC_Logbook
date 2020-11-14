package com.company.November.Comparator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

public class Day_23 {

    public static void printInfo() {
        EmployeeNameComparator comp = new EmployeeNameComparator();
        Collections.sort(Employees.employees, comp);

        for (var e : Employees.employees) {
            var info = " Employee: " + e.getName() + ";\n Hours worked " + e.getHours() + ";\n hourly wage " + e.getMoney()
                    + "\n Payment this month: " + e.getHours() * e.getMoney();
            System.out.println(info);
        }
    }

    public static void generateMonthlyFile(String path, String month) throws IOException {
        String date = String.valueOf(LocalDate.now());
        String filename = date.replace("-", "");

        File Dir = new File(path + File.separator + month);
        if (!Dir.exists()) {
            Dir.mkdirs();
        }

        EmployeeNameComparator comp = new EmployeeNameComparator();
        Collections.sort(Employees.employees, comp);

        for (var e : Employees.employees) {
            var info = " Employee: " + e.getName() + ";\n Hours worked " + e.getHours() + ";\n hourly wage " + e.getMoney()
                    + "\nPayment this month: " + e.getHours() * e.getMoney();

            File pay = new File(path + File.separator + month + File.separator + e.getName() + filename);
            FileWriter myWriter = new FileWriter(pay);
            myWriter.write(info);
            myWriter.close();
        }
    }

    public static void getMonthList(Map<String, Integer> hoursPerMonth, Map<String, Integer> hourlyWage) {

        var names = hoursPerMonth.keySet();

        for (var n : names) {

            var name = n;
            var hours = hoursPerMonth.get(name);
            var money = hourlyWage.get(name);

            Employees.employees.add(new Employee(name, hours, money));
        }
    }
}
