package csv;

import csv.DTO.Config;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Evaluator ev = new Evaluator();
        Mapper m = new Mapper(Config.CSV_PATH);

        long start = System.currentTimeMillis();
        var csv = m.getTopCaseDTOs();
        var topList = ev.getTopCases(csv);
        CsvUtil.writeToCsv(Config.OUTPUT_PATH, topList);

        long stop = System.currentTimeMillis();
        System.out.println(csv.size() + " lines proceeded in " + (stop - start) + " ms.");
    }

    // if ram requires proceeding line by line
    // CsvUtil.loadCsvByLine(Config.CSV_PATH, Main::writeLine);
    public static void writeLine(String s) {
        try {
            CsvUtil.appendText(String.valueOf(Config.OUTPUT_PATH), s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
