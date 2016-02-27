package com.shulga.algorithms.arrays;

/**
 * Find subarray with given sum
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: Sum found between indexes 2 and 4
 * <p>
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Ouptut: Sum found between indexes 1 and 4
 * <p>
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 */
public class FindSubArrayWithGivenSum {

    public static void main(String[] args) {
        System.out.println(new FindSubArrayWithGivenSum().run(new int[]{1, 4, 20, 3, 10, 5}, 33));
        System.out.println(new FindSubArrayWithGivenSum().run(new int[]{1, 4, 0, 0, 3, 10, 5}, 7));
    }

    private String run(int[] A, int sum) {
        int tempSum = 0;
        int i;
        int start = 0;
        for (i = 0; i < A.length; i++) {
            if (tempSum == sum) {
                return start + " " + (i-1);
            }
            tempSum += A[i];
            while (tempSum > sum && start < i) {
                tempSum -= A[start];
                start++;
            }
        }
        return "Not found";
    }
}
