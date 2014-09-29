package com.shulga.interview.arrays;

/**
 * Given a sorted array, there is only one value K has multiple occurrence, find
 * the repeating element and its first occurrence.
 * <p/>
 * Created by ievgen on 9/29/2014.
 */
public class FindRepeatingNumberInSortedArray {

    public int find(int[] ar) {
        return findInternal(ar, 0, ar.length - 1);
    }

    private int findInternal(int[] ar, int low, int high) {
        return -1;
    }
}
