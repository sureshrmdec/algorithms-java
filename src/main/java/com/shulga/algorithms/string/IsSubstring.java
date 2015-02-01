package com.shulga.algorithms.string;

/**
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s (i.e., “waterbottle” is a rotation of “erbottlewat”).
 * <p/>
 * Created by ievgen on 10/9/2014.
 */
public class IsSubstring {

    public static boolean isSubstringRotation(String s1, String s2) {
        char[] charsS1 = s1.toCharArray();
        for (int i = 0; i < charsS1.length; i++) {
            if (s2.charAt(0) != charsS1[i]) continue;
            for (int j = 0; j < s1.length(); j++) {
                if (j == s1.length() - i) {
                    int n = 0;
                    for (int k = j; k < s2.length(); k++) {
                        if (charsS1[n] != s2.charAt(j)) {
                            break;
                        }
                        return true;
                    }
                }
                if (s2.charAt(j) != charsS1[j + i]) {
                    break;
                }

            }
        }
        return false;
    }

    public static boolean isSubstring(String s1, String s2) {
        char[] charsS1 = s1.toCharArray();
        for (int i = 0; i < charsS1.length; i++) {
            if (s2.charAt(0) != charsS1[i]) continue;
            int j;
            for (j = 0; j < s2.length(); j++) {
                if (s2.charAt(j) != charsS1[j + i]) {
                    break;
                }
            }
            if (j == s2.length()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length() && s2.length() > 0) {
            String s2s2 = s2 + s2;
            if (isSubstring(s2s2, s1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubstring("hello", "hello"));
        System.out.println(isRotation("hello", "elloh"));
    }
}
