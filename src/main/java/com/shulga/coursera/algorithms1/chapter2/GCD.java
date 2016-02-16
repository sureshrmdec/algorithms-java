package com.shulga.coursera.algorithms1.chapter2;

/**
 * Created by ievgen on 7/20/2015.
 */
public class GCD {
    static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(gcd(24, 56));
        System.out.println(gcd2(24, 56));
    }
}
