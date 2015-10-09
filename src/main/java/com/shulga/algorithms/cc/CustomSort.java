package com.shulga.algorithms.cc;

/**
 * Created by eshulga on 10/9/15.
 * <p>
 * Give you an array which has n integers,it has both positive and negative integers.
 * Now you need sort this array in a special way.After that,the negative integers should in the front,
 * and the positive integers should in the back.Also the relative position should not be changed.
 * eg. -1 1 3 -2 2 ans: -1 -2 1 3 2.
 * o(n)time complexity and o(1) space complexity is perfect.
 */
public class CustomSort {
    void sort(int[] ar) {
        int front = 0;
        int end = ar.length - 1;
        while (end >= front) {
            while (ar[front] > 0) {
                front++;
            }
            while (ar[end] < 0) {
                end--;
            }
            if(end>front) {
                exch(ar, front, end);
            }
        }
    }

    void exch(int[] ar, int a, int b) {
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    public static void main(String[] args) {
        int[] ar = {-1, 1, 3, -2, 2};
        new CustomSort().sort(ar);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
}
