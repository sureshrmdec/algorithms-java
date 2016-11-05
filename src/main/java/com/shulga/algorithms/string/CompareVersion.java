package com.shulga.algorithms.string;

/**
 * Created by eshulga on 10/26/16.
 */
public class CompareVersion {

    public static void main(String[] args) {
        System.out.println(new CompareVersion().run("0.001", "0.001"));
    }

    private int run(String v1, String v2) {
        int i = 0;
        while (i < v1.length() || i < v2.length()) {
            if (i < v1.length() && i < v2.length()) {
                if (v1.charAt(i) > v2.charAt(i)) {
                    return 1;
                } else if (v1.charAt(i) < v2.charAt(i)) {
                    return -1;
                }
            } else if (i < v1.length()) {
                if (v1.charAt(i) != '0') {
                    return 1;
                }
            } else if (i < v2.length()) {
                if (v2.charAt(i) != '0') {
                    return -1;
                }
            }
            i++;
        }
        return 0;
    }
}
