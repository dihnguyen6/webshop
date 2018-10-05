package com.mrKhoai.webshop.beta;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;

public class TestFunction {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Generates random string of given length from Base65 alphabet (numbers, lowercase letters, uppercase letters).
     *
     * @return random string of random
     * length
     */
    public static String randomString() {
        RANDOM.setSeed(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        int count = RANDOM.nextInt(10) + 10;
        for (int i = 0; i < count; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
}
