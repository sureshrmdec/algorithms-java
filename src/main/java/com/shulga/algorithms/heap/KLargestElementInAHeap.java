package com.shulga.algorithms.heap;

import com.shulga.co.ch4.HeapMaxPriority;

/**
 * Created by eshulga on 6/24/16.
 */
public class KLargestElementInAHeap {
    private int[] ar;

    public static void main(String[] args) {
        HeapMaxPriority h = new HeapMaxPriority();
        h.insert(3);
        h.insert(5);
        h.insert(1);
        h.insert(10);
        h.insert(-5);
        new KLargestElementInAHeap().kLargest(h, 4);
    }

    private int kLargest(HeapMaxPriority h, int k) {
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = (int) h.delMax();
        }
        for (int i = 0; i < k; i++) {
            h.insert(temp[i]);
        }
        return temp[k - 1];
    }



}
