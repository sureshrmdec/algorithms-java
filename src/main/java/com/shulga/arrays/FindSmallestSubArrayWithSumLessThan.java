package com.shulga.arrays;

/**
 * Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
 * <p>
 * Examples:
 * arr[] = {1, 4, 45, 6, 0, 19}
 * x  =  51
 * Output: 3
 * Minimum length subarray is {4, 45, 6}
 * <p>
 * arr[] = {1, 10, 5, 2, 7}
 * x  = 9
 * Output: 1
 * Minimum length subarray is {10}
 * <p>
 * arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
 * x = 280
 * Output: 4
 * Minimum length subarray is {100, 1, 0, 200}
 */
public class FindSmallestSubArrayWithSumLessThan {
    public static void main(String[] args) {
        System.out.println(new FindSmallestSubArrayWithSumLessThan().run2(new int[]{1, 4, 45, 6, 0, 19}, 51));
        System.out.println(new FindSmallestSubArrayWithSumLessThan().run2(new int[]{4, 45, 6}, 9));
        System.out.println(new FindSmallestSubArrayWithSumLessThan().run2(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280));
    }

    private int run2(int[] A, int sum) {
        int minLength = A.length;
        int minDelta = Integer.MAX_VALUE;
        int tempSum = 0;
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            tempSum += A[i];
            while (tempSum > sum && start < i) {
                if ((tempSum - sum) < minDelta) {
                    minLength = i - start;
                }
                tempSum -= A[start];
                start++;
            }
            minLength = Math.min(tempSum, minLength);
        }
        return minLength;
    }

    private int run(int[] ints, int sum) {
        int minSize = ints.length;
        for (int j = 0; j < ints.length; j++) {
            int tempSum = ints[j];
            if (tempSum > sum) {
                return 1;
            }
            for (int k = j + 1; k < ints.length; k++) {
                tempSum += ints[k];
                if (tempSum > sum && (k - j + 1) < minSize) {
                    minSize = k - j + 1;
                }
            }
        }
        return minSize;
    }
}
