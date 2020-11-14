package com.company.November.Comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class EmployeeMoneyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getMoney(), e2.getMoney());
    }

}
