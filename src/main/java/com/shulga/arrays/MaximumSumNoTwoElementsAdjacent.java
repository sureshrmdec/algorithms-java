package com.shulga.arrays;

/**
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers
 * in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 1 5 10 1 1 7
 * should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 */
public class MaximumSumNoTwoElementsAdjacent {

    public static void main(String[] args) {
        System.out.println(new MaximumSumNoTwoElementsAdjacent().run(new int[]{3,2,7,10}));
    }

    public static int run(int[] ar) {
        int incl = ar[0];
        int excl = 0;
        int excl_new;
        int j;
        for (j = 1; j < ar.length; j++) {
            //current max excluding i
            excl_new = (incl > excl) ? incl : excl;
            //currect max including i
            incl = excl + ar[j];
            excl = excl_new;
        }
        //return max of incl and excl
        return ((incl > excl) ? incl : excl);
    }
}
