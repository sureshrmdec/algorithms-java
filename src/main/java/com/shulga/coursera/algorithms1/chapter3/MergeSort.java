package com.shulga.coursera.algorithms1.chapter3;

/**
 * Created by ievgen on 10/7/2014.
 */
public class MergeSort {

    public void mergeSort(Comparable[] ar) {
        Comparable[] copy = new Comparable[ar.length];
        sort(ar, copy, 0, ar.length - 1);
    }

    public static void main(String[] args) {
        Integer[] ar = {2, 3, 1, 4, 5, 6, 3, 7, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(ar);
        mergeSort.print(ar);
    }

    private void print(Comparable[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

    private void sort(Comparable[] ar, Comparable[] copy, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(ar, copy, low, mid);
        sort(ar, copy, mid + 1, high);
        merge(ar, copy, low, mid, high);
    }

    private void merge(Comparable[] ar, Comparable[] copy, int low, int mid, int high) {
        assert isSorted(ar, low, mid);
        assert isSorted(ar, mid + 1, high);

        for (int i = low; i <= high; i++) {
            copy[i] = ar[i];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) ar[k] = copy[j++];
            else if (j > high) ar[k] = copy[i++];
            else if (less(copy[i], copy[j])) ar[k] = copy[i++];
            else ar[k] = copy[j++];
        }

        assert isSorted(ar, low, high);

    }

    private boolean isSorted(Comparable[] ar) {
        return isSorted(ar, 0, ar.length);
    }

    private boolean isSorted(Comparable[] ar, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            if (less(ar[i], ar[i - 1])) return false;
        }
        return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
}
