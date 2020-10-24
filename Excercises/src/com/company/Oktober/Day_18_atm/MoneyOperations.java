package com.company.Oktober.Day_18_atm;

public class MoneyOperations {

    private static double amount = 1000;

    public static double getAmount(){
        return amount;
    }

    public static void payMoney(double money){
        MoneyOperations.amount += money;
    }

    public static void getMoney(double money){
        MoneyOperations.amount -= money;
    }
}
