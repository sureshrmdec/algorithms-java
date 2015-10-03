package com.shulga.algorithms.string;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * <p/>
 * Created by ievgen on 10/8/2014.
 */
public class RemoveDuplicatesInString {

    public static String removeDuplicatesNoExtraSpace(String str) {
        if (str == null) return str;
        int length = str.length();
        if (length == 1) return str;

        char[] chars = str.toCharArray();

        int tail = 1;

        for (int i = 1; i < length; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (chars[i] == chars[j]) {
                    break;
                }
            }
            if (tail == j) {
                chars[tail++] = chars[i];
            }
        }
        if (tail < length - 1) {
            chars[tail] = 0;
        }
        return new String(chars);
    }

    public static String removeDuplicates(String str) {
        if (str == null) return str;
        int length = str.length();
        if (length == 1) return str;

        char[] chars = str.toCharArray();

        boolean[] hit = new boolean[256];
        hit[chars[0]] = true;

        int tail = 0;
        for (int i = 1; i < length; i++) {
            if (!hit[chars[i]]) {
                chars[++tail] = chars[i];
                hit[chars[i]] = true;
            }
        }
        if (tail < length - 1) {
            chars[++tail] = 0;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("hhedddlo"));
        System.out.println(removeDuplicatesNoExtraSpace("hhedddlo"));
    }
}
