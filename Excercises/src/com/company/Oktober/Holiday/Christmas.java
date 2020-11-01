package com.company.Oktober.Holiday;

import java.util.*;

/***
 * simple solution for "Wichteln"
 * better algorithm would be Fisher-Yates-Shuffle
 * in case of Wichtel instead of persons:
 *    while (persons[i].equals( wichtel[randomIndex]){
 *       randomIndex = random.nextInt(2);
 *     }
 */

public class Christmas {

    public void printPersonsAndWichtel(List<String> persons) {

        for (var p : persons) {
            var words = p.split(" ");
            System.out.println(words[0] + " -> " + words[1]);
        }
    }

    public List<String> getWichtel(String[] allPersons) {

        ArrayList<String> persons = new ArrayList<>(Arrays.asList(allPersons));
        List<String> wichtels = new ArrayList<>(Arrays.asList(allPersons));
        List<String> wichtelMatches = new ArrayList<>();

        Random random = new Random();
        int len = persons.size();

        for (; len >= 0; len--) {
            while (wichtels.size() > 0) {
                int r = random.nextInt(len);
                var person = persons.get(len - 1);
                var wichtel = wichtels.get(r);

                if (persons.size() == 1 && person.equals(wichtel)) {
                    return getWichtel(allPersons);
                }

                if (wichtels.contains(wichtel) && !wichtel.equals(person)) {
                    persons.remove(person);
                    wichtels.remove(wichtel);
                    wichtelMatches.add(person + " " + wichtel);
                    break;
                }
            }
        }
        return wichtelMatches;
    }
}
