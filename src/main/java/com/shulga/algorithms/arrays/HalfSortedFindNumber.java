package com.shulga.algorithms.arrays;

/**
 * 1. Given an array that is first increasing then decreasing, find an element in it.
 * Example: arr[] = { 2,6,8,9,15,20,18,16,12,7,1}; x = 12, Find x.
 */
public class HalfSortedFindNumber {
    public static void main(String[] args) {
        System.out.println(new HalfSortedFindNumber().run(new int[]{2, 6, 8, 9, 15, 20, 18, 16, 12, 7, 1}, 12));
    }

    private int run(int[] ar, int num) {
        int gs = 0;
        int gm = ar.length / 2;
        int ge = ar.length - 1;
        int s = gs;
        int e = gm;
        Integer mid = binarySearch(ar, num, s, e,0);
        if (mid >= 0) {
            return mid;
        }
        s = gm;
        e = ge;
        mid = binarySearch(ar, num, s, e, 1);
        return mid;
    }

    private Integer binarySearchReq(int[] ar, int num, int s, int e) {
        if (s > e) return -1;
        int mid = s + (e - s) / 2;
        if (ar[mid] == num) {
            return mid;
        } else if (ar[mid] > num) {
            return binarySearchReq(ar, num, s, mid - 1);
        } else {
            return binarySearchReq(ar, num, mid + 1, e);
        }
    }

    private Integer binarySearch(int[] ar, int num, int s, int e,int reverse) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (ar[mid] == num) {
                return mid;
            } else if (ar[mid] > num) {
                if(reverse==1){
                    s = mid + 1;
                }else {
                    e = mid-1;
                }
            } else {
                if(reverse==1){
                    e = mid - 1;
                }else {
                    s = mid+1;
                }
            }
        }
        return -1;
    }
}
