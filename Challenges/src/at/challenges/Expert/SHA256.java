package at.challenges.Expert;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    public static String encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        StringBuilder sb = new StringBuilder();

        var bytes = md.digest(str.getBytes(StandardCharsets.UTF_8));

        for (var b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString().toLowerCase();
    }
}
