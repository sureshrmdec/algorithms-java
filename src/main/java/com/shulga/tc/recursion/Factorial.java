package com.shulga.tc.recursion;

/**
 * Created by ievgen on 11/8/14.
 */
public class Factorial {

    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(fact(3));
    }
}
