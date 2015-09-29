package com.shulga.algorithms.arrays;

import java.util.Arrays;

/**
 * How to find efficiently the minimum of an array of integers that is the maximum of other arrays?
 * <p>
 * Example:
 * A = [126, 110, 130]
 * B = [125]
 * C = [105, 115]
 * <p>
 * The minimum element of array A that is the maximum of B and C is 126
 * <p>
 * Created by ievgen on 2/1/2015.
 */
public class MinInArrayMaxOtherArrays {

    public static int find(int[] ar, int[]... other) {
        if (ar.length == 0) {
            return -1;
        }
        int maxInArrays = 0;
        for (int[] item : other) {
            for (int i = 0; i < item.length; i++) {
                if (item[i] > maxInArrays) {
                    maxInArrays = item[i];
                }
            }
        }

        Arrays.sort(ar);
        int result = binarySearch(maxInArrays, ar);
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < ar.length; i++) {
//            if (ar[i] > maxInArrays && ar[i] < result) {
//                result = ar[i];
//            }
//        }
//        return result == Integer.MAX_VALUE ? -1 : result;
        return result;
    }

    private static int binarySearch(int val, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo != hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= val) lo = mid + 1;
            else hi = mid;
        }
        return a[lo] >= val ? a[lo] : -1;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{126, 110, 130}, new int[]{125}, new int[]{105, 115})); // 126
        System.out.println(find(new int[]{126, 110, 130}, new int[]{128}, new int[]{105, 115})); // 130
        System.out.println(find(new int[]{125}, new int[]{126, 110, 130}, new int[]{105, 115})); // -1
        System.out.println(find(new int[]{80, 120, 90, 126, 127, 128}, new int[]{125}, new int[]{105, 115})); // 126
    }
}
