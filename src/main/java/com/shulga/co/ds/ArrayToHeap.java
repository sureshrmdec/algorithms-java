package com.shulga.co.ds;

/**
 * Created by eshulga on 6/14/16.
 */
public class ArrayToHeap {
    public static void main(String[] args) {
        int[] ar = {0, 5, 3, 4, 2, 1};
        new ArrayToHeap().run(ar);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

    private void run(int[] ar) {
        for (int i = 0; i < ar.length / 2; i++) {
            sinkdown(i, ar, ar.length);
        }
        int last = ar.length - 1;
        for (int i = 0; i < ar.length; i++) {
            swap(0, last, ar);
            last--;
            sinkdown(0, ar, last);
        }
    }

    public void sinkdown(int k, int[] ar, int length) {
        while (k * 2 + 1 < length) {
            int target = k * 2 + 1;
            if (target + 1 < length && ar[target + 1] > ar[target]) {
                target += 1;
            }
            if (ar[k] > ar[target]) return;
            swap(target, k, ar);
            k = target;
        }
    }

    private void swap(int m, int k, int[] ar) {
        int temp = ar[k];
        ar[k] = ar[m];
        ar[m] = temp;
    }
}
