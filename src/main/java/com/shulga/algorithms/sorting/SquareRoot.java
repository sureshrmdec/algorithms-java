package com.shulga.algorithms.sorting;

/**
 * Created by eugene on 9/16/16.
 */
public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(new SquareRoot().run(100));
    }

    private int run(int num) {

        int s = 1;
        int e = num / 2 + 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid * mid < num) {
                s = mid+1;
            } else if (mid * mid > num) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
