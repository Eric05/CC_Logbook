package com.company.Oktober;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


import static java.util.Comparator.comparing;

/*** Textanalysis
 * _ Anzahl Characters
 * _ Anzahl “echte” (ausgesprochen) Characters
 * _ Anzahl Wörter
 * _ Kürzeste / Längste Wort
 * _ Anzahl vorkommen von Wort “Hesse”
 * _ Anzahl Wörter mit ausschließlich klein oder GROßBUCHSTABEN
 */

public class Day_12 {

    // const Path
    private final static String PATH = "C:\\dev\\Hesse.txt";

    // private fields
    private String input;
    private String cleanInput;
    private List<String> cleanList = new ArrayList<>();

    // getters
    public List<String> getCleanList() {
        return cleanList;
    }

    public String getCleanInput() {
        return cleanInput;
    }

    public String getInput() {
        return input;
    }

    // setters
    public void setInput(String input) {
        this.input = input;
    }

    // default constructor
    public Day_12() {
        setInput(readFile(PATH));
        cleanInput = generateCleanString();
        cleanList = generateCleanList();
    }

    // parameterized constructor
    public Day_12(String input) {
        this.setInput(input);
    }

    // public Methods
    public int getChars() {
        return getInput().length();
    }

    public int getSpokenChars() {
        String noSpace = getCleanInput().replaceAll("\\s{1,}", "");
        return noSpace.length();
    }

    public int countWords() {
        return getCleanList().size();
    }

    public String getLongestWord() {
        var clean = new ArrayList<>(getCleanList());
        clean.sort(comparing(String::length));

        return clean.get(clean.size() - 1);
    }


    public String getShortestWord() {
        var clean = new ArrayList<String>(getCleanList());
        Pattern isDigit = Pattern.compile("-?\\d+(\\.\\d+)?");

        clean.sort(comparing(String::length).thenComparing(String::compareTo));
        var cleanListWithoutDigits = clean.stream()
                                                      .filter(s -> !isDigit.matcher(s).matches())
                                                      .collect(Collectors.toList());
        return cleanListWithoutDigits.get(0);
    }

    public int countHesse() {
        int counter = 0;
        String pattern = "Hesse";

        for (String w : getCleanList()) {
            if (w.equals(pattern)) {
                counter++;
            }
        }
        return counter;
    }

    public int countOnlyLowerOrUpper() {
        int counter = 0;

        for (String w : getCleanList()) {
            if (isOnlyUpperOrLower(w)) {
                counter++;
            }
        }
        return counter;
    }

    // Helper Methods
    private boolean isOnlyUpperOrLower(String word) {

        Pattern isUpper = Pattern.compile(".*[A-Z].*");
        Pattern isLower = Pattern.compile(".*[a-z].*");
        Matcher mLower = isLower.matcher(word);
        Matcher mUpper = isUpper.matcher(word);

        if (mLower.matches() && !mUpper.matches()) {
            return true;
        }
        if (!mLower.matches() && mUpper.matches()) {
            return true;
        }
        return false;
    }

    private String generateCleanString() {
        var text = readFile(PATH);

        var noLinebreaks = text.replaceAll("\\\\n", "");
        var noSpecialChars = noLinebreaks.replaceAll("[.,;:?!+\"\\\\]", "");
        var trimmed = noSpecialChars.replaceAll("\\s{2,}", " ").trim();

        return trimmed;
    }

    private List<String> generateCleanList() {
        var cleanArray = generateCleanString().split(" ");
        var cleanList = Arrays.asList(cleanArray);

        return cleanList;
    }

    private String readFile( String path) {
        StringBuilder sb = new StringBuilder();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                sb.append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("wrong path");
        }
        return sb.toString();
    }

    private void writeFile(String text, String path){

        try {
            var  wr = new FileWriter(path);
            wr.write(text);
            wr.close();
            // System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            // System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
