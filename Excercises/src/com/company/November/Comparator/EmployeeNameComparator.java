package com.company.November.Comparator;

import java.util.Comparator;

      // list.sort(Comparator.comparingInt(Employee::getYear));
      // list.sort(Comparator.comparing(Employee::isMale).reversed());

public class EmployeeNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {

        return e1.getName().compareToIgnoreCase(e2.getName());
    }
}
