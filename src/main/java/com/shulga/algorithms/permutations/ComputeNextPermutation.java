package com.shulga.algorithms.permutations;


/**
 * Created by eshulga on 8/30/16.
 */
public class ComputeNextPermutation {
    public static void main(String[] args) {
        int[] run = new ComputeNextPermutation().run(new int[]{1, 3, 9, 8, 7});
        for (int i = 0; i < run.length; i++) {
            System.out.print(run[i] + " ");
        }
    }

    private int[] run(int[] perm) {
        int end = perm.length - 2;
        while (perm[end] > perm[end + 1] && end>=0) {
            end--;
        }
        int s = end + 1, e = perm.length - 1;
        //reverse
        while (s < e) {
            int tmp = perm[s];
            perm[s] = perm[e];
            perm[e] = tmp;
            s++;
            e--;
        }
        int tmp = perm[end];
        perm[end] = perm[end + 1];
        perm[end + 1] = tmp;
        return perm;

    }
}
