package com.shulga.algorithms.heap;

import java.util.PriorityQueue;

/**
 * Created by eshulga on 6/14/16.
 */
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] run = new MergeSortedArrays().run(new int[]{1, 2, 3}, new int[]{6, 8, 9}, new int[]{4, 5, 6});
        for (int i = 0; i < run.length; i++) {
            System.out.println(run[i]);
        }
    }

    private int[] run(int[] ar1, int[] ar2, int[] ar3) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(ar1[0], 0, ar1));
        pq.add(new Pair(ar2[0], 0, ar2));
        pq.add(new Pair(ar3[0], 0, ar3));
        int[] res = new int[ar1.length + ar2.length + ar3.length];
        int counter = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            res[counter++] = pair.value;
            Pair next = pair.getNext();
            if (next != null) {
                pq.add(next);
            }
        }
        return res;
    }

    class Pair implements Comparable<Pair> {
        int value;
        int index;
        int[] ar;

        Pair(int value, int index, int[] ar) {
            this.value = value;
            this.index = index;
            this.ar = ar;
        }

        Pair getNext() {
            if (++index >= ar.length) return null;
            return new Pair(ar[index], index, ar);
        }

        @Override
        public int compareTo(Pair o) {
            if (value == o.value) return 0;
            return value < o.value ? -1 : 1;
        }
    }
}
