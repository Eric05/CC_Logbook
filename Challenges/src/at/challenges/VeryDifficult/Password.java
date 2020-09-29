package at.challenges.VeryDifficult;

import java.util.regex.Pattern;

enum Level {

    High("5"),
    Good("4"),
    Okay("3");

    private String strength;

    public String getStrength() {
        return this.strength;
    }

    Level(String strength) {
        this.strength = strength;
    }
}

public class Password {

    public static String passwordStrength(String password) {
        var res = 0;
        var levels = Level.values();

        if (Pattern.matches(".*[0-9].*", password)) {
            res += 1;
        }
        if (Pattern.matches(".*[a-z].*", password)) {
            res += 1;
        }
        if (Pattern.matches(".*[A-Z].*", password)) {
            res += 1;
        }
        if (Pattern.matches(".*[\\W].*", password)) {
            res += 1;
        }
        if (password.length() > 5) {
            res += 1;
        }

        for (var l : levels) {
            if (Integer.valueOf(l.getStrength()) == res) {
                return l.name();
            }
        }
        return "too weak";
    }
}
