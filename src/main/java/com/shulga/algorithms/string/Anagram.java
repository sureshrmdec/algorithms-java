package com.shulga.algorithms.string;

/**
 * Write a method to decide if two strings are anagrams or not.
 * <p/>
 * Created by ievgen on 10/8/2014.
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("hheea", "eeshh"));
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] letters = new int[256];
        int num_letters = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (letters[c] == 0) num_letters++;
            letters[c]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (letters[c] == 0) return false;
            letters[c]--;
            if (letters[c] == 0) {
                num_letters--;
            }
            if (num_letters == 0) {
                return i == s2.length() - 1;
            }
        }
        return false;
    }
}
