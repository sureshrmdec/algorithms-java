package com.shulga.algorithms.tc.div2practice;

/**
 * Created by eshulga on 10/13/15.
 */
public class BearPlaysDiv2 {
    String equalPiles(int A, int B, int C) {
        if (A + B + C % 3 != 0) {
            return "impossible";
        }
        return "possible";
    }

    public static void main(String[] args) {
        System.out.println(new BearPlaysDiv2().equalPiles(10, 15, 35));
    }
}
