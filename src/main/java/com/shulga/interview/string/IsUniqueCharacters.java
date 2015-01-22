package com.shulga.interview.string;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
 * <p>
 * Created by ievgen on 10/8/2014.
 */
public class IsUniqueCharacters {

    public static boolean isUniqueCharacters(String str) {
        boolean[] ar = new boolean[255];
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if (ar[ch]) return false;
            ar[ch] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueCharacters("hola sir"));
        System.out.println(isUniqueCharacters("hello guys"));
    }
}
