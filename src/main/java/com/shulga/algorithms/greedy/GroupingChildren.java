package com.shulga.algorithms.greedy;

/**
 * Created by eugene on 9/24/16.
 */
public class GroupingChildren {
    public static void main(String[] args) {
        System.out.println(minNumberOfGroups(new double[]{1, 1.2, 1.4, 1.5, 2,2.1, 4.5, 7}));
    }

    private static int minNumberOfGroups(double[] doubles) {
        int numberOfGroups = 0;
        int start=0;
        while(start<doubles.length){
            double end = doubles[start]+1;
            while(start<doubles.length && doubles[start]<end){
                start++;
            }
            numberOfGroups++;
        }
        return numberOfGroups;
    }
}
