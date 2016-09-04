package com.shulga.algorithms.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by eshulga on 8/29/16.
 */
public class TopKElemets {
    Comparator<HeapEntry> comp = new Comparator<HeapEntry>() {
        @Override
        public int compare(HeapEntry heapEntry, HeapEntry t1) {
            return t1.value.compareTo(heapEntry.value);
        }
    };

    public static void main(String[] args) {
        List<Integer> run = new TopKElemets().run(new int[]{50, 40, 30, 20, 25, 18, 10, 1}, 5);
        for (Integer i : run) {
            System.out.print(i + " ");
        }
    }

    private List<Integer> run(int[] heap, int k) {
        PriorityQueue<HeapEntry> pq = new PriorityQueue<>(11, comp);
        List<Integer> result = new ArrayList<>();
        pq.add(new HeapEntry(heap[0], 0));
        for (int i = 0; i < k; i++) {
            HeapEntry poll = pq.poll();
            result.add(poll.value);
            int indx = poll.index;
            int left = indx * 2 + 1;
            if (left < heap.length) {
                pq.add(new HeapEntry(heap[left], left));
            }
            int right = indx * 2 + 2;
            if (right < heap.length) {
                pq.add(new HeapEntry(heap[right], right));
            }
        }
        return result;
    }

    static class HeapEntry {
        Integer value;
        int index;
        public HeapEntry(Integer value, int index) {
            this.value = value;
            this.index = index;
        }
    }


}
