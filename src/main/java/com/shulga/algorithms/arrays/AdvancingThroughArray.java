package com.shulga.algorithms.arrays;

/**
 * Created by eshulga on 8/27/16.
 */
public class AdvancingThroughArray {

    public static void main(String[] args) {
        System.out.println(new AdvancingThroughArray().run(new int[]{3, 3, 1, 0, 2, 0, 1}));
        System.out.println(new AdvancingThroughArray().run(new int[]{3, 2, 0, 0, 2, 0, 1}));
        System.out.println(new AdvancingThroughArray().run(new int[]{2, 4, 1, 1, 0, 2, 3}));
    }

    private boolean run(int[] ints) {
        int maxSoFar = 0;
        for (int i = 0; i < ints.length && maxSoFar >= i; i++) {
            maxSoFar = Math.max(maxSoFar, i + ints[i]);
        }
        return maxSoFar > ints.length - 1;
    }
}
