package com.shulga.algorithms.arrays;

/**
 * Created by eugene on 9/16/16.
 * Examples:
 * arr[] = {1, 4, 45, 6, 0, 19}
 * x  =  51
 * Output: 3
 * Minimum length subarray is {4, 45, 6}
 * <p/>
 * arr[] = {1, 10, 5, 2, 7}
 * x  = 9
 * Output: 1se
 * Minimum length subarray is {10}
 * <p/>
 * arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
 * x = 280
 * Output: 4
 * Minimum length subarray is {100, 1, 0, 200}
 */
public class MinLengthSubArraySumGreaterK {

    public static void main(String[] args) {
        System.out.println(new MinLengthSubArraySumGreaterK().run(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250},280));
    }//1,10, 4, 45, 6, 0, 19

    private int run(int[] ints, int k) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (left <= right) {
            while (sum < k && right < ints.length) {
                sum += ints[right++];
            }
            if (sum < k) return result;
            result = Math.min(result, right - left + 1);
            while (sum>= k) {
                sum-=ints[left++];
                result = Math.min(result, right - left + 1);
            }
        }
        return result;
    }
}
