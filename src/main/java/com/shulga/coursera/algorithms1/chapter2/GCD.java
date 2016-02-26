package com.shulga.coursera.algorithms1.chapter2;

/**
 * Created by ievgen on 7/20/2015.
 */
public class GCD {
    static int gcd(int p, int q) {
        if (q == 0) return p;
        int q1 = p % q;
        return gcd(q, q1);
    }


    public static void main(String[] args) {
        System.out.println(gcd(8, 25));
        System.out.println(LCM(8, 25));
    }

    static int gcd2(int p, int q) {
        while (q != 0) {
            int res = p % q;
            p = q;
            q = res;
        }
        return p;
    }

    static int LCM(int a,int b){
        return (a*b)/gcd(a,b);
    }
}
