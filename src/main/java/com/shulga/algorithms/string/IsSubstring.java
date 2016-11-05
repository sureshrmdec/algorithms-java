package com.shulga.algorithms.string;

/**
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s (i.e., “waterbottle” is a rotation of “erbottlewat”).
 * <p>
 * Created by ievgen on 10/9/2014.
 */
public class IsSubstring {

    public static void main(String[] args) {
        System.out.println(isSubstringRotation2("waterbottle","erbos"));
    }

    public static boolean isSubstringRotation2(String s1, String s2) {
        char[] chars = s1.toCharArray();
        int s2Start=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] !=s2.charAt(s2Start)) continue;
            int iSoFar=i;
            int j;
            for (j = 0; j < s2.length(); j++) {
                if(s2.charAt(j)!=s1.charAt(iSoFar)){
                    break;
                }
                iSoFar++;
                if(iSoFar==s1.length()) {
                    iSoFar=0;
                }
            }
            if(j==s2.length()) return true;
        }
        return false;
    }

}
