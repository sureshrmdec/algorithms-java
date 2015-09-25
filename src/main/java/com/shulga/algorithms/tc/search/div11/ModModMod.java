package com.shulga.algorithms.tc.search.div11;

/**
 * Created by eshulga on 9/24/15.
 */
public class ModModMod {
    long findSum(int[] m, int R) {
        int sum = 0;
        for (int i = 1; i <= R; i++) {
            int num = i;
            for (int j = 0; j < m.length; j++) {
                if (num < m[j]) {
                    continue;
                }
                num = num % m[j];
            }
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ModModMod().findSum(new int[]{2934}, 10000000));
    }
}
