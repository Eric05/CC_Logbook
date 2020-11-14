package com.company.November.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employees {

    public static List<Employee> employees = new ArrayList<>();

    public Employees() {
        generateList();
    }

    public void printEmployees() {
        EmployeeNameComparator comp = new EmployeeNameComparator();
        Collections.sort(employees, comp);
        
        for (var e : employees) {
            System.out.println(e.getName() + " " + e.getHours() + " " + e.getMoney());
        }
    }


    private void generateList() {
        employees.add(new Employee("Albert", 16, 12));
        employees.add(new Employee("Mike", 32, 132));
        employees.add(new Employee("Sabi", 14, 32));
    }

}
