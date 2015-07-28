package com.shulga.coursera.algorithms1.chapter2;

/**
 * Created by ievgen on 7/20/2015.
 */
public class GCD {
    static int  gcd(int p,int q){
        if (q == 0) return p;
        return gcd(q,  p % q);
    }

    public static void main(String[] args) {
        System.out.println(gcd(4,2));
    }
}
