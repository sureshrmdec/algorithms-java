package com.shulga.coursera.dp;

/**
 * Created by eugene on 3/12/16.
 * you are given a set of bars of gold and your goal is to take as much gold as possible
 * into your bag. There is just one copy of each bar and for each bar you can either take it or not (hence
 * you cannot take a fraction of a bar).
 * <p>
 * Input:
 * 10 3
 * 1 4 8
 * Output:
 * 9
 */
public class AsMuchGoldAsPossible {
    public static void main(String[] args) {
        int[] weights = {1, 4, 8};
        System.out.println(new AsMuchGoldAsPossible().runReq(10, weights, weights.length - 1));
    }

    private int runReq(int W, int[] weights, int n) {
        if (W == 0 || n < 0) {
            return 0;
        }
        if (weights[n] > W) {
            return runReq(W, weights, n - 1);
        }
        return Math.max(
                runReq(W, weights, n - 1),
                weights[n] + runReq(W - weights[n], weights, n - 1)
        );
    }

    private int run(int W, int[] weights) {
        int[][] dp = new int[W + 1][weights.length + 1];
        for (int j = 0; j < weights.length; j++) {
            for (int w = 0; w <= W; w++) {
                if (W <= 0) {
                    dp[j][w] = dp[j-1][w];
                }
                if (weights[j] > W) {
                    continue;
                }
            }
        }
        return -1;
    }
}
