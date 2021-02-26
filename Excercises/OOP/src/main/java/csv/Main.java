package csv;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        Evaluator ev = new Evaluator(Config.CSV_PATH);
        var topList = ev.getTopCases();
        CsvUtil.writeToCsv(Config.OUTPUT_PATH, topList);

        long stop = System.currentTimeMillis();
        System.out.println(ev.getFilesize() + " lines proceeded in " + (stop - start) + " ms.");
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
