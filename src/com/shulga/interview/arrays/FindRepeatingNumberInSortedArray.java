package com.shulga.interview.arrays;

/**
 * Given a sorted array, there is only one value K has multiple occurrence, find
 * the repeating element and its first occurrence.
 * <p/>
 * Created by ievgen on 9/29/2014.
 */
public class FindRepeatingNumberInSortedArray {

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 5, 5};
        System.out.println(new FindRepeatingNumberInSortedArray().find(ar)); //3
    }

    public int find(int[] ar) {
        return findInternal(ar, 0, ar.length - 1);
    }

    private int findInternal(int[] ar, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        }
        if (ar[mid] == ar[mid + 1]) {
            if (mid == low || ar[mid - 1] != ar[mid]) {
                return mid;
            } else {
                return findInternal(ar, low, mid - 1);
            }
        } else {
            int found = findInternal(ar, low, mid - 1);
            if (found != -1) {
                return found;
            } else {
                return findInternal(ar, mid + 1, high);
            }
        }
    }
}
