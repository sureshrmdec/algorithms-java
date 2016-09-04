package com.shulga.algorithms.heap;

import java.util.*;

/**
 * Created by eshulga on 7/8/16.
 */
public class IndexedMaxPQ {
    private int n; //number of elements
    private List<String> pq;
    private HashMap<String, Integer> qp;
    private HashMap<String, Integer> keys;

    public IndexedMaxPQ() {
        n = 0;
        pq = new ArrayList();
        pq.add("");
        qp = new HashMap<>();
        keys = new HashMap<>();
    }


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1a", 5);
        map.put("2a", 2);
        map.put("44a", 44);
        map.put("45a", 45);
        map.put("7a", 7);
        map.put("0a", 0);

        IndexedMaxPQ pq = new IndexedMaxPQ();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.insert(entry.getKey(), entry.getValue());
        }

        // delete and print each key
        for (String s : pq.topK(10)) {
            System.out.println(s);
        }
        System.out.println("====================");

        pq.increaseKey("44a");
        pq.increaseKey("44a");
        System.out.println(pq.delMax());


        System.out.println(pq.keyOf("1a"));
        PriorityQueue<Integer> smallpq = new PriorityQueue<>();
        smallpq.add(43);
        smallpq.add(1);
        smallpq.add(78);
        while(!pq.isEmpty()){
            System.out.println(smallpq.poll());
        }

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(String index) {
        return qp.containsKey(index);
    }

    public int size() {
        return n;
    }

    public void insert(String index, Integer key) {
        if (contains(index)) throw new IllegalArgumentException("index already exist in PQ");
        n++;
        qp.put(index, n);
        pq.add(n, index);
        keys.put(index, key);
        swim(n);
    }

    private void swim(int n) {
        while (n > 1 && greater(n / 2, n)) {
            exchange(n / 2, n);
            n = n / 2;
        }
    }

    private boolean greater(int i, int j) {
        return keys.get(pq.get(i)).compareTo(keys.get(pq.get(j))) < 0;
    }

    private void exchange(int i, int j) {
        String temp = pq.get(i);
        pq.set(i, pq.get(j));
        pq.set(j, temp);
        qp.put(pq.get(i), i);
        qp.put(pq.get(j), j);
    }

    public String delMax() {
        if (n == 0) throw new NoSuchElementException("empty pq");
        String min = pq.get(1);
        exchange(1, n);
        n--;
        sink(1);
        qp.put(min, -1);
        keys.remove(min);
        pq.remove(n + 1);
        return min;
    }

    public int keyOf(String index) {
        if (!contains(index))
            throw new NoSuchElementException(String.format("Index %s is not in the priority queue", index));
        return keys.get(index);
    }

    public List<String> topK(int k) {
        IndexedMaxPQ copy = new IndexedMaxPQ();
        int min = Math.min(k, keys.size());
        for (int i = 1; i <= min; i++) {
            copy.insert(pq.get(i), keys.get(pq.get(i)));
        }
        List<String> top = new ArrayList<>();
        while (!copy.isEmpty()) {
            top.add(copy.delMax());
        }
        return top;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (greater(j, k)) break;
            exchange(j, k);
            k = j;
        }
    }

    public void increaseKey(String index) {
        if (!contains(index)) throw new NoSuchElementException("index is not in the priority queue");
        Integer existing = keys.get(index);
        keys.put(index, existing + 1);
        swim(qp.get(index));
    }

}
