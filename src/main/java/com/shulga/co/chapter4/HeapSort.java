package com.shulga.co.chapter4;

/**
 * Created by ievgen on 10/7/2014.
 */
public class HeapSort {
    private int N;
    private Comparable[] ar;

    public static void main(String[] args) {
        Comparable[] ar = {2, 1, 4, 3, 2, 6, 9, 3, 2};
        HeapSort sort = new HeapSort();
        sort.heapSort(ar);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

    public void heapSort(Comparable[] ar) {
        this.ar = ar;
        N = ar.length;
        for (int i = N / 2; i >= 1; i--) {
            sink(i);
        }
        while (N > 1) {
            exch(1, N--);
            sink(1);
        }
    }

    private void sink(int item) {
        while (2 * item <= N) {
            int j = 2 * item;
            if (j < N && less(j, j + 1)) j++;
            if (less(j, item)) return;
            exch(item, j);
            item = j;
        }
    }

    private void exch(int item, int j) {
        Comparable temp = ar[item - 1];
        ar[item - 1] = ar[j - 1];
        ar[j - 1] = temp;
    }

    private boolean less(int j, int i) {
        return ar[j - 1].compareTo(ar[i - 1]) < 0;
    }
}
