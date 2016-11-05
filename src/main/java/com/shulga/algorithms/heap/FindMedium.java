package com.shulga.algorithms.heap;

import com.shulga.co.ch4.HeapMaxPriority;
import com.shulga.co.ch4.HeapMinPriorityQueue;

/**
 * Created by eshulga on 6/15/16.
 * min max
 * {3}{3}
 * {3,5}{3}
 * {3,5,9}{3}
 * {5,9}{3,3}
 * {5,9,11}{3,3}
 * {5,9,11,20}{3,3}
 * {9,11,20}{5,3,3}
 * {9,11,20,30}{5,3,3}
 * {9,11,20,30,40}{5,3,3}
 * {11,20,30,40}{9,5,3,3}
 */
public class FindMedium {

    public static void main(String[] args) {
        new FindMedium().run(new Comparable[]{3, 3, 5, 9, 11, 20, 30, 40});
    }

    private void run(Comparable[] ar) {
        HeapMaxPriority maxPQ = new HeapMaxPriority();
        HeapMinPriorityQueue minPQ = new HeapMinPriorityQueue(ar.length);
        for (int i = 0; i < ar.length; i++) {
            Comparable el = ar[i];
            minPQ.insert(el);

            //Balance
            int diff = minPQ.size() - maxPQ.size();
            if (diff > 1) {
                maxPQ.insert(minPQ.delMin());
            }

            //print mean
            if (minPQ.size() == maxPQ.size()) {
                System.out.println(((Integer) minPQ.peek() + (Integer) maxPQ.peek()) / 2);
            } else if (minPQ.size() > maxPQ.size()) {
                System.out.println(minPQ.peek());
            }
        }
    }
}
