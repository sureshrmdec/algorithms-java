package com.shulga.co.dp;

import java.util.Arrays;

/**
 * Created by eshulga on 10/25/16.
 */
public class CoinChangeDP {

    public static void main(String[] args) {
        System.out.println(new CoinChangeDP().coinChange(new int[]{1, 2, 5},11));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
