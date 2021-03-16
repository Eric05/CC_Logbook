package com.company.Tests;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Test1 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        var str = "hi, jpo, go, home, xcy";
        var last = str.lastIndexOf(",");
        var left = str.substring(0,last) + ". ";
        var right = str.substring(last+1);
        var res = left + right;

        var password = "a";
        SecureRandom random = new SecureRandom();
        byte[] salt = "xyz".getBytes(StandardCharsets.UTF_8);
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = factory.generateSecret(spec).getEncoded();

        StringBuilder result = new StringBuilder();
        for (byte aByte : hash) {
            result.append(String.format("%02x", aByte));
        }
        System.out.println(result.toString());

        int[] outer = new int[]{1, 3, 5, 3};
        int[] inner = new int[]{1, 5};

        parenBit("abc123");


    }

    public static String parenBit(String str) {

        return "";
    }

}





