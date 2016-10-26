package com.shulga.algorithms.arrays;

import java.util.Arrays;

/**
 * Created by eshulga on 10/21/16.
 */
public class HIndex {

    public static void main(String[] args) {
        System.out.println(new HIndex().run(new int[]{0,1}));
    }

    private int run(int[] citations) {
        if(citations.length==1 && citations[0]==0) return 0;
        if(citations.length==1) return 1;
        Arrays.sort(citations);
        for (int i = citations.length-1; i >= 0; i--) {
            int current = citations[i];
            if(i<=current && citations.length-i>=current){
                return current;
            }
        }
        return 0;
    }
}
