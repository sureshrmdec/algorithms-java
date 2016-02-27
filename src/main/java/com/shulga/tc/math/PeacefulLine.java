package com.shulga.tc.math;

/**
 * Created by eshulga on 10/5/15.
 */
public class PeacefulLine {

    String makeLine(int[] x){
        int[] counts = new int[26];
        for (int i = 0; i < x.length; i++) {
            counts[x[i]]++;
        }
        for (int i = 0; i < counts.length; i++) {
            if(counts[i]>x.length/2){
                return "imposibble";
            }
        }
        return "possible";
    }

    public static void main(String[] args) {
        System.out.println(new PeacefulLine().makeLine(new int[]{}));
    }
}
