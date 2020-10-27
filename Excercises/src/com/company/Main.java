package com.company;

import com.company.Oktober.Holiday.Christmas;
import com.company.Oktober.Holiday.GuessingGame;

import java.util.Random;
import java.util.Scanner;


public class Main {

    public static final String RED = "\u001B[31m";

    public static void main(String[] args) throws Exception {

        Random random = new Random();
        int idx = 2;

        while (idx == 2){
            idx = random.nextInt(2);
        }
        System.out.println(idx);

        boolean isValid = false;
        while (!isValid) {

            try {
                Scanner sc = new Scanner(System.in);
                var inp = sc.nextInt();
                isValid = true;
            } catch (Exception e) {
                System.out.println( e.getMessage() );;
            }

        }
        System.out.println("Well done");
/*
        GuessingGame gg = new GuessingGame();
        gg.play();*/

        Christmas c = new Christmas();
        String[] persons = new String[]{"Eric", "Lucas", "Klaus", "Dan"};
        String[] gifts = new String[]{"Pc", "Snack", "Car", "Coffee"};

        String[] giftsCopy = c.shuffleArray(gifts);

        c.printPersonsAndGifts(persons, giftsCopy);
/*        Encryption enc = new Encryption();
        var res = enc.encrypt("Java");
        System.out.println(res);
        var dec = enc.decrypt(res);
        System.out.println(dec);*/
    }
}






