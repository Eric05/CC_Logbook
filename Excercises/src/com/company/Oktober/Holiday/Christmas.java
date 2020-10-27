package com.company.Oktober.Holiday;

import java.util.Arrays;
import java.util.Random;

/***
 * simple solution for "Wichteln"
 * better algorithm would be Fisher-Yates-Shuffle
 */

public class Christmas {
    String[] persons = new String[]{"Eric", "Lucas", "Klaus", "Dan"};
    String[] gifts = new String[]{"Pc", "Snack", "Car", "Coffee"};

    public void printPersonsAndGifts(String[] persons, String[] gifts) {

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i] + " gets " + gifts[i]);
        }
    }

    public String[] shuffleArray(String[] gifts) {
        int len = gifts.length;
        String[] giftsCopy = Arrays.copyOf(gifts, len);
        Random random = new Random();

        for (int i = 0; i < giftsCopy.length; i++) {
            int randomIndex = random.nextInt(len);

            String tmp = giftsCopy[randomIndex];
            giftsCopy[randomIndex] = giftsCopy[i];
            giftsCopy[i] = tmp;
        }
        return giftsCopy;
    }
}
