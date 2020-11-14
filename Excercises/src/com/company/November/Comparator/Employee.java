package com.company.November.Comparator;

public class Employee {

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer money;
    private Integer hours;
    private String name;

    public Employee(String name, Integer money, Integer hours) {
        this.name = name;
        this.money = money;
        this.hours = hours;
    }

}
