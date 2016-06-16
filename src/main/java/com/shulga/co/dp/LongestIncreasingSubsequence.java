package com.shulga.co.dp;

/**
 * Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements
 * of the subsequence are sorted in increasing order. For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 }
 * is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * <p>
 * Optimal Substructure:
 * Let arr[0..n-1] be the input array and L(i) be the length of the LIS till index i such that arr[i] is part of LIS and arr[i]
 * is the last element in LIS, then L(i) can be recursively written as.
 * L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and if there is no such j then L(i) = 1
 * <p>
 * To get LIS of a given array, we need to return max(L(i)) where 0 < i < n So the LIS problem has optimal substructure property
 * as the main problem can be solved using solutions to subproblems. Overlapping Subproblems:
 * Following is simple recursive implementation of the LIS problem. The implementation simply follows the recursive structure mentioned above.
 * The value of lis ending with every element is returned using max_ending_here. The overall lis is returned using pointer to a variable max.
 * <p>
 * { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * {30,31,33,1,2,3,4}
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().run(new int[]{10, 22, 9,  120, 33, 21, 50, 41, 60, 80}));
        System.out.println(new LongestIncreasingSubsequence().runReq(new int[]{10, 22, 9,  33, 21, 50, 41, 60, 80}));
    }

    private int runReq(int[] A) {
        return runTaskReq(A, 1);
    }

    private int runTaskReq(int[] A, int n) {
        //TODO
        return 0;
    }

    private int run(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = 1;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = 1 + dp[j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
