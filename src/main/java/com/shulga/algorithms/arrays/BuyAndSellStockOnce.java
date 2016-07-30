package com.shulga.algorithms.arrays;

/**
 * Created by eshulga on 7/27/16.
 */
public class BuyAndSellStockOnce {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 3, 1, 4, 2, 4};
        System.out.println(new BuyAndSellStockOnce().run(ar));
    }

    private int run(int[] ar) {
        int maxSoFar = ar[0];
        int min = 0;
        int max = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] >= ar[i - 1]) {
                maxSoFar = ar[i] - min;
                max = Math.max(max, maxSoFar);
            } else {
                maxSoFar = 0;
                min = ar[i];
            }
        }
        return max;
    }
}
