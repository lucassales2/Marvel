package com.example.lucassales.marvel.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lucassales on 27/11/2017.
 */

public class Security {

    public static String generateMD5Hash(String arg) {
        try {
            return new String(MessageDigest.getInstance("MD5").digest(arg.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String generateHash(String privateKey, String publicKey, long timestamp) {
        return generateMD5Hash(String.valueOf(timestamp) + privateKey + publicKey);
    }
}
