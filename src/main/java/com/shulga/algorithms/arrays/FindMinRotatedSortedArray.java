package com.shulga.algorithms.arrays;

/**
 * Created by ievgen on 11/11/14.
 */
public class FindMinRotatedSortedArray {

    public static int find(int[] ar) {
        int last = ar.length - 1;
        int first = 0;
        while (true) {
            int mid = (last - first) / 2 + first;
            if (ar[mid] > ar[last]) {
                first = mid + 1;
            } else if (ar[mid] < ar[last]) {
                last = mid - 1;
            } else {
                return ar[mid];
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = {5, 6, 7, 81, 2, 3, 4};
        System.out.println(find(ar));
    }
}
