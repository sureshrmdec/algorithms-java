package com.shulga.algorithms.string;

/**
 * Created by eshulga on 8/23/16.
 */
public class RemoveReplaceFromString {
    public static void main(String[] args) {
        //remove 1
        //replace 2=>0
        System.out.println(new RemoveReplaceFromString().run("1s21a2s11"));
    }

    private String run(String s) {
        int counter = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != '1') {
                chars[counter++] = chars[i];
            }
        }
        counter--;
        int i;
        for (i = chars.length - 1; counter >= 0 && i >= 0; i--, counter--) {
            if (chars[counter] != '2') {
                chars[i] = chars[counter];
            } else {
                chars[i] = '0';
                chars[i - 1] = '0';
                i--;
            }
        }
        return new String(chars).substring(i + 1, s.length());
    }
}
