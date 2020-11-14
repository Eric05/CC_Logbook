package com.company.September;

import com.company.November.Day_22;

import java.util.Arrays;

public class Test2DArray {


    public static void main(String[] args) {
        // var list = Day_22.readCSV("C:\\dev\\Stundenliste.txt", ",");


                String[][] stundenRechnung = Day_22.readCSV("C:\\Users\\DCV\\Downloads\\Stunden.csv", ",");
                for (int i = 0; i < stundenRechnung.length; i++) {
                    for (int j = 0; j < stundenRechnung[i].length; j++) {
                        System.out.println((stundenRechnung[i][j]));
                    }

                }
                int[] lohn = calLohn(stundenRechnung);
                printLohAabrechnung(lohn);

                int[] hours = new int[3];
                int[] days = new int[3];
                calAverageWorkingHours(stundenRechnung, hours, days);
                printAverageHours(hours, days);

                int cntEmployee = countEmployee(stundenRechnung);
                System.out.println("Gesamt Mitarbeiter Zahl lautet: "+cntEmployee);
            }

            public static int[] calLohn(String[][] field) {
                int grundLohnPerStunde = 7;
                int[] mitarbeiterLohn = new int[3];
                for (int row = 0; row < field.length; row++) {

                    if (field[row][0].equals("Daniel")) {

                        int summe = Integer.parseInt(field[row][1]) * grundLohnPerStunde;
                        mitarbeiterLohn[0] = mitarbeiterLohn[0] + summe;
                    }

                    if (field[row][0].equals("Alex")) {
                        int summe = Integer.parseInt(field[row][1]) * grundLohnPerStunde;
                        mitarbeiterLohn[1] = mitarbeiterLohn[1] + summe;
                    }

                    if (field[row][0].equals("Michael")) {
                        int summe = Integer.parseInt(field[row][1]) * grundLohnPerStunde;
                        mitarbeiterLohn[2] = mitarbeiterLohn[2] + summe;
                    }
                }
                return mitarbeiterLohn;
            }

            //durchschnittliche Stunden per Tag
            public static void calAverageWorkingHours(String[][] stundenListe, int[] hours, int[] days) {
                // row = 0 ist Kopfzeile, die beim Berechnung nicht verwendet wird
                for (int row = 1; row < stundenListe.length; row++) {
                    int sumhours = Integer.parseInt(stundenListe[row][1]);
                    if (stundenListe[row][0].equals("Daniel")) {
                        hours[0] += sumhours;
                        ++days[0];
                    }
                    if (stundenListe[row][0].equals("Alex")) {
                        hours[1] += sumhours;
                        ++days[1];
                    }
                    if (stundenListe[row][0].equals("Michael")) {
                        hours[2] += sumhours;
                        ++days[2];
                    }
                }
            }

            public static void printLohAabrechnung(int[] lohn) {
                System.out.println("-------------------------------");
                System.out.println("Daniel bekommt " + lohn[0] + "€ ausbezahlt.");
                System.out.println("Alex bekommt " + lohn[1] + "€ ausbezahlt.");
                System.out.println("Michael bekommt " + lohn[2] + "€ ausbezahlt.");
                System.out.println("-------------------------------");
            }
            public static void printAverageHours(int[] hours, int[] days) {
                System.out.println("-------------------------------");
                System.out.println("Daniel arbeitet durchschnittlich " + String.format("%.2f", (float)hours[0]/(float)days[0]) + " per Monat");
                System.out.println("Alex arbeitet durchschnittlich " + String.format("%.2f", (float)hours[1]/(float)days[1]) + " per Monat");
                System.out.println("Michael arbeitet durchschnittlich " + String.format("%.2f", (float)hours[2]/(float)days[2]) + " per Monat");
                System.out.println("-------------------------------");
            }

            public static int countEmployee(String[][] stundenListe){
                int countNames = 0;
                // 하나의 어레이에서  index는 자연히 동시에 생긴다. 이 정보를 활용하라.
                String alleNamen = "#";
                for (int i = 1; i < stundenListe.length; i++) {

                    if (alleNamen.indexOf("#" + stundenListe[i][0] + "#") < 0){
                        // = (!alleNamen.contains("#" + stundenListe[i][0] + "#") < 0)
                        alleNamen += stundenListe[i][0]+"#";
                        ++countNames;
                    }
                    System.out.println(alleNamen);
                }
                String[] list = alleNamen.split("#");
                // 한 단어를  split기능으로 array에 넣을 수 있다.
                System.out.println(Arrays.toString(list));
                return countNames;
            }

}

