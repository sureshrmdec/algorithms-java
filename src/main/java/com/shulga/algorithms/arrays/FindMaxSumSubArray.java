package com.shulga.algorithms.arrays;

/**
 * The task of finding the contiguous subarray which has the largest sum.
 * <p>
 * <p>
 * 1. Maintain two variables: maxSoFar and maxEndingAtCurrentPosition in Array.
 * 2. Update maxEndingAtCurrentPosition if (maxEndingAtCurrentPosition + current[i]) > than 0.
 * 3. Keep on updating maxSoFar whenever maxEndingAtCurrentPosition is greater than maxSoFar.
 * <p>
 * http://en.wikipedia.org/wiki/Kadane%27s_Algorithm
 * <p>
 * Created by ievgen on 9/29/2014.
 */
public class FindMaxSumSubArray {

    public static int findMaxSubArray(int[] arr) {
        int maxEndingHere = 0;
        int maxTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + arr[i]);
            maxTotal = Math.max(maxTotal, maxEndingHere);
        }
        return maxTotal;
    }

    public static int findMaxArrayNative(int[] arr) {
        int maxSoFar = 0;
        int maxTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = maxSoFar + arr[i];
            if (sum > 0) {
                maxSoFar = sum;
            } else {
                maxSoFar = 0;
            }
            if (maxSoFar > maxTotal) {
                maxTotal = maxSoFar;
            }
        }
        return maxTotal;
    }

    public static void main(String[] args) {
        int[] ar = {1, 1, -3, 1, -7, 1, 2};
        System.out.println(findMaxSubArray(ar));
        System.out.println(findMaxArrayNative(ar));
    }
}
