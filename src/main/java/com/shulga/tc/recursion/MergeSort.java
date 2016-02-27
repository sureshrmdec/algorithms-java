package com.shulga.tc.recursion;

import java.util.LinkedList;

/**
 * Created by ievgen on 10/7/2014.
 */
public class MergeSort {

    public void mergeSort(Comparable[] ar) {
        Comparable[] copy = new Comparable[ar.length];
        sort(ar, copy, 0, ar.length - 1);
    }

    public static void main(String[] args) {
        Integer[] ar = {2, 3, 1, 4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(ar);
        mergeSort.bottomUpSort(ar);
        mergeSort.print(ar);
        LinkedList list= new LinkedList();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(10);
        System.out.println(list);
        mergeSort.bottomUpSortLinkedList(list);
        System.out.println(list);
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

    void insertionSort(Comparable[] a,int left,int right){
        for (int i = left; i <= right; i++) {
            Comparable temp = a[i];
            int j = i - 1;
            while (j >= left && a[j].compareTo(temp) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[++j] = temp;
        }
    }

    private void sortImproved(Comparable[] ar, Comparable[] copy, int low, int high,int cutoff) {
        if (high-low<=cutoff) {
            insertionSort(ar,low,high);
            return;
        }
        int mid = low + (high - low) / 2;
        sort(ar, copy, low, mid);
        sort(ar, copy, mid + 1, high);
        if (copy[mid].compareTo(copy[mid + 1]) <= 0) {
            for (int i = low; i <= high; i++)
                ar[i] = copy[i];
        }else {
            merge(ar, copy, low, mid, high);
        }
    }

    private void bottomUpSort(Comparable[] a){
        int N = a.length;
        Comparable[] copy = new Comparable[a.length];
        for (int sz = 1; sz < N; sz = sz+sz) {
            for(int lo = 0;lo<N-sz;lo+=sz+sz){
                merge(a,copy,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
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


    private void bottomUpSortLinkedList(LinkedList<Comparable> a){
        int N = a.size();
        for (int sz = 1; sz < N; sz = sz+sz) {
            for(int lo = 0;lo<N-sz;lo+=sz+sz){
                mergeLinkedList(a, lo, lo + sz - 1, Math.min(lo+sz+sz-1,N-1));
            }
        }
    }

    private void mergeLinkedList(LinkedList<Comparable> l,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        while(i!=high) {
            if (less(l.get(j), l.get(i)) || l.get(j).compareTo(l.get(i)) == 0) {
                l.add(i, l.get(j));
                l.remove(++j);
            }
            i++;
        }
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
