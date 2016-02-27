package com.shulga.algorithms.arrays;

/**
 * Created by eshulga on 10/9/15.
 * You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists.
 * <p>
 * For example,
 * List 1: [4, 10, 15, 24, 26]
 * List 2: [0, 9, 12, 20]
 * List 3: [5, 18, 22, 30]
 * <p>
 * The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.
 */
public class FindTherSmallestRange {

    int[] find(int[] ar){
        return ar;
    }

    public static void main(String[] args) {
        int[] ints = new FindTherSmallestRange().find(new int[]{});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
