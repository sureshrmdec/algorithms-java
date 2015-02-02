package com.shulga.algorithms.arrays;

/**
 * Given N elements array, move all evens to left and all odds to right.
 * Do not use extra array.
 * <p/>
 * O(N) time complexity
 *
 * Created by ievgen on 9/29/2014.
 */
public class EvensToLeftAndOddsToRight {

    public static void main(String[] args) {
        int[] ar = {1, 3, 2, 4, 5, 6, 8, 4, 324, 67, 97, 342, 23};
        new EvensToLeftAndOddsToRight().perform(ar);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

    public void perform(int[] ar) {
        int start = 0;
        int end = ar.length - 1;
        while (start <= end) {
            while (ar[start] % 2 == 0) {
                start++;
            }
            while (ar[end] % 2 != 0) {
                end--;
            }
            if (start < end) {
                swap(start, end, ar);
            }
        }
    }

    private void swap(int one, int two, int[] ar) {
        int temp = ar[one];
        ar[one] = ar[two];
        ar[two] = temp;
    }
}
