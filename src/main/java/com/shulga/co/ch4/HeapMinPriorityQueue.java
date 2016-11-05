package com.shulga.co.ch4;

/**
 * Created by eshulga on 10/15/15.
 */
public class HeapMinPriorityQueue {
    private Comparable[] ar;
    private int N;
    private int nSize = 0;
    public HeapMinPriorityQueue(int n) {
        ar = new Comparable[n];
        nSize = n;
    }

    public int size(){
        return N;
    }

    public void insert(Comparable item) {
        ar[++N] = item;
        swim(N);
    }

    private void swim(int n) {
        while (n > 1 && less(n, n / 2)) {
            exch(n / 2, n);
            n = n / 2;
        }
    }

    public Comparable peek() {
        return ar[1];
    }

    public Comparable delMin() {
        Comparable min = ar[1];
        exch(1, N--);
        ar[N + 1] = null;
        sink(1);
        return min;
    }

    private void sink(int index) {
        while (index * 2 <= N ) {
            int j = index * 2;
            if (j < N && less(j + 1, j)) {
                j++;
            }
            if(less(index,j)){
                return;
            }
            exch(index, j);
            index = j;
        }
    }

    public boolean less(int a, int b) {
        return ar[a].compareTo(ar[b]) < 0;
    }

    private void exch(int n, int i) {
        Comparable temp = ar[n];
        ar[n] = ar[i];
        ar[i] = temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public static void main(String[] args) {
        HeapMinPriorityQueue h = new HeapMinPriorityQueue(20);
        h.insert(2);
        h.insert(555);
        h.insert(8);
        h.insert(5);
        h.insert(8);
        h.insert(1);
        h.insert(23);
        System.out.println(h.delMin());
        System.out.println(h.delMin());
        System.out.println(h.delMin());
        System.out.println(h.delMin());
        System.out.println(h.delMin());
        System.out.println(h.delMin());
        System.out.println(h.delMin());
        System.out.println(h.delMin());
    }
}
