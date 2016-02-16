package com.shulga.algorithms.tc.srm;

/**
 * Created by eshulga on 9/21/15.
 */
public class VerySecureEncryption {

    String encrypt(String message, int[] key, int K) {
        int n = message.length();
        char[] res = new char[n];
        for (int i = 0; i < K; i++) {
            char[] chars = message.toCharArray();
            for (int j = 0; j < n; j++) {
                res[key[j]] = chars[j];
            }
            message = new String(res);
        }
        return message;
    }

    public static void main(String[] args) {
        int[] key = {4, 3, 6, 2, 5, 1, 0, 7};
        System.out.println(new VerySecureEncryption().encrypt("uogcodlk", key, 44));
    }
}
