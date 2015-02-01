package com.shulga.algorithms.arrays;

/**
 * Given two sorted (ascending) arrays of integers, where the integers do not repeat and the two arrays have no common integers.
 * Let x be any integer in the first array, y any integer in the second. Find min(Abs(x-y)). That is, find the smallest
 * difference between any of the integers in the two arrays.
 * Created by ievgen on 11/9/14.
 */
public class MinDiffSortedArray {
    public static int minDiff(int[] one, int[] two) {
        int min = Math.abs(one[0] - two[0]);
        int i = 1;
        int j = 1;
        while (i < one.length && j < two.length) {
            int diff = Math.abs(one[i] - two[j]);
            if (diff < min) {
                min = diff;
            }
            if (one[i] > two[i]) {
                j++;
            } else {
                i++;
            }
        }
        return min;
    }

    /*
    * Concatenate x + y
    * */
    public static void concatenateNumbers(long x, long y) {
        long temp = y;
        do {
            temp = temp / 10;
            x = x * 10;
        } while (temp > 0);
        System.out.println(x + y);
    }


    public static void main(String[] argsx) {
        int[] ar1 = {1, 5, 8};
        int[] ar2 = {-5, 10, 20};
        concatenateNumbers(123, 144);
        System.out.println(minDiff(ar1, ar2));
    }
}
