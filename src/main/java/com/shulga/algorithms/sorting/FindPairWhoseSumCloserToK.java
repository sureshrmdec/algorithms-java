package com.shulga.algorithms.sorting;

/**
 * Created by eugene on 9/6/16.
 */
public class FindPairWhoseSumCloserToK {
    public static void main(String[] args) {
        new FindPairWhoseSumCloserToK().run(new int[]{10, 22, 28, 29, 30, 40}, 5);
    }

    private void run(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        int diff = Integer.MAX_VALUE;
        int x1 = arr[s];
        int x2 = arr[e];
        while (s < e) {
            if (k - arr[s] + arr[e] < diff) {
                diff = k - arr[s] + arr[e];
                x1 = arr[s];
                x2 = arr[e];
            }
            if (arr[s] + arr[e] < k) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(x1 + " " + x2);
    }
}
