package com.shulga.algorithms.tc.recursion;

import java.util.Comparator;

/**
 * Created by eugene on 10/3/15.
 */
public class QuickSort {
    public void sort(Comparable[] a,int low, int high){
        if(low>=high){
            return;
        }
        //shuffle(a)
        int median = getMedianOf3(a,low,(low+high/2),high);
        exch(a,low,median);
        int j = getPartition(a, low, high);
        sort(a, low, j);
        sort(a, j + 1, high);
    }

    private int getMedianOf3(Comparable[] a,int low,int mid,int high){
        if(less(a[low],a[mid])){
            if(less(a[mid],a[high])){
                return mid;
            }else{
                return high;
            }
        }else if(less(a[low],a[high])){
            return low;
        }
        return high;
    }

    public static void main(String[] args) {
        Integer[] ar = {2, 3, 1, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(ar, 0, ar.length - 1);
        quickSort.print(ar);
    }

    private void print(Comparable[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

    private void sort3way(Comparable[] a,int low,int high){
        if(low>=high) return;
        int lt = low;
        int gt = high;
        int i=lt+1;
        Comparable p = a[lt];
        while(i<gt){
            if(less(a[i],p)){
                exch(a,i,lt);
                i++;
                lt++;
            }else if(less(p,a[i])){
                exch(a,i,gt);
                gt--;
            }else{
                i++;
            }
        }
        sort3way(a,0,lt);
        sort3way(a,i+1,high);
    }

    private int getPartition(Comparable[] a, int low, int high) {
        int i=low;
        int j = high+1;
        Comparable p = a[low];
        while(true){
            while(less(a[++i],p)){
                if(i==high) break;
            }
            while (less(p,a[--j])){
                if(j==low) break;
            }
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,low,j);
        return j;
    }

    void exch(Comparable[] ar,int i,int j){
        Comparable temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
}
