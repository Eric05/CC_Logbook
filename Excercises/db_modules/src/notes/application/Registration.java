package notes.application;

import notes.application.services.UserService;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Registration {

    private final UserService repo = new UserService();

    public static byte[] hashPassword(String password) {
        int iterations = 10000;
        int keyLength = 512;
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = "1234".getBytes();

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerUser(String name, String pw) {
        var hash = hashPassword(pw);
        String hashedString = Hex.encodeHexString(hash);
        repo.registerUser(name, hashedString);
    }

    public boolean isValid(String name, String pw) {
        var hash = hashPassword(pw);
        String hashedString = Hex.encodeHexString(hash);

        return repo.getUser(name, hashedString) != null;
    }
}
