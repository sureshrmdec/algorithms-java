package com.shulga.coursera.dp;

/**
 * Created by eshulga on 3/11/16.
 */
public class KnapSack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
//        System.out.println(new KnapSack().run(50, new int[]{10, 20, 30}, val, val.length));
        System.out.println(new KnapSack().runDP(2, new int[]{1, 1, 1}, val, val.length));
    }

    private int runDP(int W, int[] weights, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - weights[i - 1]],
                            dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][W];
    }

    private int run(int W, int[] wt, int[] val, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] > W) {
            return run(W, wt, val, n - 1);
        }
        return Math.max(
                run(W, wt, val, n - 1),
                val[n - 1] + run(W - wt[n - 1], wt, val, n - 1)
        );
    }
}
