package com.company;


import com.company.November.Comparator.Day_23;
import com.company.November.Comparator.Employee;
import com.company.November.Comparator.Employees;
import com.company.November.Day_22;
import com.company.November.Day_24;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {



        var list = Day_24.getExcelFromFile("C:\\dev\\Stundenliste.txt",2, ",");

        Day_24.isValidInputAdvanced("C:\\dev\\Stundenliste.txt", ",");

        System.out.println(list.size());



/*        var employees = new Employees();
        var d = new Day_22();
        var hours = d.sumHours(d.getExcelFromFile("C:\\dev\\Stundenliste.txt",2, ","));
        var income = d.getIncome("C:\\dev\\Lohn.txt");*/

/*        Day_23.getMonthList(hours, income);
        Day_23.printInfo();
        Day_23.generateMonthlyFile("C:\\dev\\Abrechnung", "Nov");*/
    }
}














