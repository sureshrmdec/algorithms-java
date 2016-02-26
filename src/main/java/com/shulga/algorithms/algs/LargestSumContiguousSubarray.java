package com.shulga.algorithms.algs;

/**
 * Created by eugene on 11/29/15.
 */
public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        System.out.println(find(new int[]{-2, -3, -4, -1, -2, 1, -5, -3}));
        System.out.println(findHandleNegatives(new int[]{-2, -3, -4, -1, -2, -1, -5, -3,1,2}));
    }

    public static int find(int[] ar){
        int maxSoFar = 0;
        int max = 0;
        for (int i = 0; i < ar.length; i++) {
            maxSoFar = maxSoFar+ar[i];
            if(maxSoFar<0){
                maxSoFar=0;
            }
            else if(maxSoFar>max){
                max=maxSoFar;
            }
        }
        return max;
    }

    public static int findHandleNegatives(int[] ar){
        int maxHere = ar[0];
        int max = ar[0];
        for (int i = 1; i < ar.length; i++) {
            maxHere = Math.max(maxHere,maxHere+ar[i]);
            max = Math.max(maxHere,max);
        }
        return max;
    }
}
