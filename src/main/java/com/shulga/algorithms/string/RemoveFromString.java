package com.shulga.algorithms.string;

/**
 * remove("hello world", "ld") ====> heo wor
 * <p>
 * Created by eshulga on 11/7/14.
 */
public class RemoveFromString {

    public static String remove(String str, String remove) {
        char[] strAr = str.toCharArray();
        char[] remAr = remove.toCharArray();
        boolean[] flags = new boolean[256];

        for (int i = 0; i < remove.length(); i++) {
            flags[remAr[i]] = true;
        }

        int src = 0;
        int dst = 0;
        while (src < str.length()) {
            if (!flags[strAr[src]]) {
                strAr[dst++] = strAr[src];
            }
            src++;
        }
        return new String(strAr, 0, dst);
    }

    public static void main(String[] args) {
        System.out.println(remove("hello world", "ld"));
    }
}
