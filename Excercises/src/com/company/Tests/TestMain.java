package com.company.Tests;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TestMain {
    public static void main(String[] args) {
       var x = stringX("xxHxix");
    }

    private static String  stringX(String str) {
        Pattern pattern = Pattern.compile("^[^ $x]");

        return str.replaceAll(String.valueOf(pattern), "");

    }


}
