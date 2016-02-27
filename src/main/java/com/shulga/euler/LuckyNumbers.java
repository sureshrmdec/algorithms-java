package com.shulga.euler;

/**
 * Created by eugene on 11/29/15.
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        System.out.println(run(6));
    }

    private static boolean run(int n) {
        int counter = 2;
        while (true) {
            if (counter > n) {
                return true;
            } else if (n % counter == 0) {
                return false;
            } else {
                n = n - (n / counter);
            }
            counter++;
        }
    }
}
