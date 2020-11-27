package com.company.November.Day_29;

public class View {

    public static void printHuman(Human human) {
        var output = human.getFirstName() + " " + human.getLastName() +
                " " + human.getLocation() + " " + human.getYear() +
                human.isMale();
        System.out.println(output);
    }


}
