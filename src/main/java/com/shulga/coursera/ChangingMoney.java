package com.shulga.coursera;

/**
 * Created by eshulga on 3/2/16.
 * <p>
 * The goal in this problem is to find the minimum number of coins needed to change the given amount
 * of money using coins with denominations 1, 5, and 10.
 * <p>
 * Input:
 * 28
 * Output:
 * 6
 * Explanation:
 * 28 = 10 + 10 + 5 + 1 + 1 + 1.
 */
public class ChangingMoney {
    public static void main(String[] args) {
        System.out.println(new ChangingMoney().run(49));
    }

    private int run(int limit) {
        int[] dp = new int[limit + 1];
        dp[1] = 0;
        for (int i = 2; i <= limit; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 10 == 0) {
                dp[i] = Math.min(dp[i - 10] + 1, i / 10);
            } else if (i % 5 == 0) {
                dp[i] = Math.min(dp[i - 5] + 1, i / 5);
            }
        }
        return dp[limit];
    }
}
