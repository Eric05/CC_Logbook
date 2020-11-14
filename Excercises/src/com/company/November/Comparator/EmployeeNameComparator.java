package com.company.November.Comparator;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {

        return e1.getName().compareToIgnoreCase(e2.getName());
    }
}
