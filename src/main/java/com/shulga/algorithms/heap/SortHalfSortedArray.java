package com.shulga.algorithms.heap;


import java.util.PriorityQueue;

/**
 * Created by eshulga on 6/14/16.
 */
public class SortHalfSortedArray {

    public static void main(String[] args) {
        int[] ar = {-1, 1, 3, 2, 5, 4};
        new SortHalfSortedArray().run(ar, 3);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

    private void run(int[] ar, int k) {
        PriorityQueue pq = new PriorityQueue();
        int i;
        for (i = 0; i <k; i++) {
            pq.add(ar[i]);
        }
        int c = 0;
        while (!pq.isEmpty()) {
            ar[c++] = (int) pq.poll();
            if(i<ar.length) {
                pq.add(ar[i++]);
            }
        }
    }
}
