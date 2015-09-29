package com.shulga.algorithms.tc.s443;

import java.util.Arrays;

/**
 * Created by eshulga on 9/29/15.
 */
public class RoyalTreasurer {
    int minimalArrangement(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i]* B[B.length-1-i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new RoyalTreasurer().minimalArrangement(new int[]{5,15,100,31,39,0,0,3,26},new int[]{11,12,13,2,3,4,5,9,1}));
    }
}
