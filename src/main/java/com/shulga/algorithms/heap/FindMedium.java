package com.shulga.algorithms.heap;

import com.shulga.co.chapter4.HeapMaxPriority;
import com.shulga.co.chapter4.HeapMinPriorityQueue;

/**
 * Created by eshulga on 6/15/16.
 * min max
 * {3}{3}
 * {3}{5,3}
 * {3,9}{3,5}
 * {3,9,11}{3,5}
 * {3,9,11,20}{3,5}
 * {9,11,20}{3,3,5}
 */
public class FindMedium {

    public static void main(String[] args) {
        new FindMedium().run(new Comparable[]{3, 3, 5, 9, 11, 20, 30,40});
    }

    private void run(Comparable[] ar) {
        HeapMaxPriority maxPQ = new HeapMaxPriority();
        HeapMinPriorityQueue minPQ = new HeapMinPriorityQueue(ar.length);
        maxPQ.insert(ar[0]);
        System.out.println(ar[0]);
        minPQ.insert(ar[1]);
        System.out.println(((int) minPQ.peek() + (int) maxPQ.peek()) / 2);
        for (int i = 2; i < ar.length; i++) {
            Comparable el = ar[i];
            //ADD
            if (el.compareTo(maxPQ.peek()) < 0) {
                maxPQ.insert(el);
            } else {
                minPQ.insert(el);
            }
            //Balance
            int diff = maxPQ.size() - minPQ.size();
            if (diff > 1) {
                minPQ.insert(maxPQ.delMax());
            } else if (diff < -1) {
                maxPQ.insert(minPQ.delMin());
            }
            //print mean
            if (minPQ.size() == maxPQ.size()) {
                System.out.println(((int) minPQ.peek() + (int) maxPQ.peek()) / 2);
            } else if (minPQ.size() > maxPQ.size()) {
                System.out.println(minPQ.peek());
            } else {
                System.out.println(maxPQ.peek());
            }
        }
    }
}
