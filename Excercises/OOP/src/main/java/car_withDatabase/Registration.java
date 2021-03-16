package car_withDatabase;

import car_withDatabase.daos.CustomerDao;
import car_withDatabase.daos.CustomerDao_MySqlImpl;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class Registration {

    private CustomerDao dao = new CustomerDao_MySqlImpl();


    public void registerUser(String name, String pw){
        var hash = hashPassword(pw);
        String hashedString = Hex.encodeHexString(hash);
        dao.registerCustomer(name,hashedString);
    }

    public boolean isValid(String name, String pw) {
        var hash = hashPassword(pw);
        String hashedString = Hex.encodeHexString(hash);
        if (dao.getCustomer(name, hashedString) != null) {
            return true;
        }
        return false;
    }

    public static byte[] hashPassword( String password) {
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
}
