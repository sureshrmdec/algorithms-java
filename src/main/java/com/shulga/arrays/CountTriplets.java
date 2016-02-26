package com.shulga.arrays;

import java.util.Arrays;

/**
 * Count triplets with sum smaller than a given value
 * 5 2
 1 5 3 4 2
 */
public class CountTriplets {
    public static void main(String[] args) {
        System.out.println(new CountTriplets().run(new int[]{5, 1, 3, 4, 7}, 12));
    }

    private int run(int[] ints, int sum) {
        int count = 0;
        Arrays.sort(ints);
        for (int i = 0; i < ints.length-2; i++) {
            int j=i+1;
            int k=ints.length-1;
            while(j<k){
                if(ints[i]+ints[j]+ints[k]>=sum){
                    k--;
                }else{
                    count+=k-j;
                    j++;
                }
            }
        }
        return count;
    }
}
