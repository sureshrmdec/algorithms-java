package com.shulga.coursera.dp;

/**
 * Created by eugene on 3/13/16.
 */
public class SellWine {
    public static void main(String[] args) {
        int[] prices = {2, 3, 5, 1, 4};
        System.out.println(new SellWine().run(prices, 0, 0, prices.length - 1));
    }

    private int run(int[] prices, int n, int start, int end) {
        if (start > end) return 0;
        return Math.max(
                run(prices, n + 1, start + 1, end) + n * prices[start],
                run(prices, n + 1, start, end - 1) + n * prices[end]
        );

    }
}
