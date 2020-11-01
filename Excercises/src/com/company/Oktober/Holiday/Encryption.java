package com.company.Oktober.Holiday;

import java.util.HashSet;

public class Encryption {

    private final String text = "#Zur Zeit des# Zweiten Weltkriegs waren #seine großen Werke Siddhartha und Der Steppenwolf noch verboten\n" +
            "Heute gehört Hermann Hesse zu den bekanntesten deutschen Schriftstellern Mehr über den Weltveränderer\n" +
            "lest ihr hier Hermann Hesse Hermann Hesse erhielt den Nobelpreis für Literatur Hermann Hesse\n" +
            "KurzSteckbrief Vollständiger Name Hermann Karl Hesse Lebensdaten 2 Juli 1877 bis 9 August 1962\n" +
            "Nationalität deutsch später schweizerisch Zitat Wenn wir einen Menschen glücklicher und heiterer\n" +
            "machen können so sollten wir es auf jeden Fall tun mag er uns darum bitten oder nicht Als\n" +
            "Schriftsteller Dichter und Maler prägte Hermann Hesse die Literatur und Kunst des 19 Jahrhunderts\n";

    private final String normalizedText = normalize(text);

    public String encrypt(String stringToEncrypt) {
        char[] chars = stringToEncrypt.toCharArray();
        char[][] map = createMap();
        int rows = map.length;
        int cols = map[0].length;
        var sb = new StringBuilder();
        HashSet<String> used = new HashSet<>();
        boolean firstSearch = true;

        for (var ch : chars) {
            loop:
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    try {
                        if (map[r][c] == ch) {
                            var coordinate = r + "." + c + " , ";

                            if (!used.contains(coordinate)) {
                                used.add(coordinate);
                                sb.append(coordinate);
                                firstSearch = true;
                                break loop;
                            } else if (!firstSearch ){
                                sb.append(coordinate);
                                break loop;
                            } else {
                                firstSearch = false;
                            }
                        }
                    } catch (Exception ignored) {
                    }
                }
            }
        }
        int idxOfLastColon = sb.toString().lastIndexOf(',');
        return sb.substring(0, idxOfLastColon);
    }

    public String decrypt(String stringToDecrypt) {
        var sb = new StringBuilder();
        char[][] map = createMap();
        String[] coordinates = stringToDecrypt.split(",");

        for (var c : coordinates) {
            var coordinateValues = c.split("\\.");
            char ch = map[Integer.parseInt(coordinateValues[0].strip())][Integer.parseInt(coordinateValues[1].strip())];
            sb.append(ch);
        }
        return sb.toString();
    }

    private char[][] createMap() {
        String[] rows = normalizedText.split("\\n");
        int rowLength = rows.length;
        int colLength = rows[0].length();

        char[][] map = new char[rowLength][colLength];

        for (int c = 0; c < colLength; c++) {
            for (int r = 0; r < rowLength; r++) {
                try {
                    map[r][c] = rows[r].charAt(c);
                } catch (Exception ignored) {
                }
            }
        }
        return map;
    }

    private String normalize(String text) {
        text = text.strip().replaceAll(" {2,}", "");

        return text;
    }

    // create charmap with jagged array from String
    public static Character[][] createCharMap(String text, String delim) {

        var lines = text.split(delim);
        var len = lines.length;
        Character[][] charMap = new Character[len][];

        for (int i = 0; i < len; i++) {
            if (lines[i] != null) {
                var line = lines[i];
                charMap[i] = new Character[line.length()];
                for (int j = 0; j < charMap[i].length; j++) {
                    charMap[i][j] = line.charAt(j);
                }
            }
        }
        return charMap;
    }
}
