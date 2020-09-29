package at.challenges.Expert;

import java.util.ArrayList;
import java.util.List;

public class ShitoriGame {

    private static List<String> used = new ArrayList<>();
    private boolean gameOver = false;

    public void play(String word) {

        if (gameOver || used.contains(word)) {
            restart();
            return;
        }
        addWord(word);
        printArr();

        if (used.size() > 2) {

            if (!check(used.get(used.size() - 1), used.get(used.size() - 2))) {
                gameOver = true;
            } else {
                addWord(word);
                printArr();
            }
        }
    }

    public void restart() {

        used.clear();
        gameOver = false;
        printGameInfo("Restarted");
    }

    public void getWords() {

        printArr();
    }

    private boolean check(String lastCharWord1, String firstCharWord2) {

        var startChar = firstCharWord2.toCharArray()[0];
        var endChar = lastCharWord1.toCharArray()[lastCharWord1.length() - 1];

        if (startChar != endChar) {
            return false;
        }
        return true;
    }

    private void addWord(String newWord) {
        used.add(newWord);
    }

    private void printArr() {

        for (var u : used) {
            System.out.print(u + " ");
        }
        System.out.println("");
    }

    private void printGameInfo(String info) {
        System.out.println(info);
    }
}
