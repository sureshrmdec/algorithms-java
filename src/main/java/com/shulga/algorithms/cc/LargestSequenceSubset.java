package com.shulga.algorithms.cc;

import java.util.Arrays;

/**
 * Created by eshulga on 10/9/15.
 * <p>
 * Given an int array which might contain duplicates, find the largest subset of it which form a sequence.
 * Eg. {1,6,10,4,7,9,5}
 * then ans is 4,5,6,7
 * Sorting is an obvious solution. Can this be done in O(n) time
 */
public class LargestSequenceSubset {

    int[] find(int[] ar) {
        Arrays.sort(ar);
        int start = 0;
        int end = 0;
        int startSoFar = 0;
        int endSoFar = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] - 1 == ar[i - 1]) {
                endSoFar = i;
            } else {
                if (end - start < endSoFar - startSoFar) {
                    start = startSoFar;
                    end = endSoFar;
                }
                startSoFar = i;
                endSoFar = i;
            }
        }
        if (end - start < endSoFar - startSoFar) {
            start = startSoFar;
            end = endSoFar;
        }
        int len = end - start + 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = ar[start + i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 6, 10, 4, 7, 9, 5, 11, 12, 13, 14};
        int[] ints = new LargestSequenceSubset().find(ar);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
