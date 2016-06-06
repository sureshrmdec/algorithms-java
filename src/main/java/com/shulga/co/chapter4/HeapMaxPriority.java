package com.shulga.co.chapter4;

/**
 * Created by ievgen on 10/7/2014.
 */
public class HeapMaxPriority {
    private Comparable[] ar;
    private int N;

    public HeapMaxPriority() {
        ar = new Comparable[5];
    }

    public HeapMaxPriority(int capacity) {
        ar = new Comparable[capacity];
    }

    public void insert(Comparable item) {
        if (N == ar.length - 1) {
            resize(N * 2);
        }
        ar[++N] = item;
        swim(N);
    }

    private void resize(int newSize) {
        Comparable[] newAr = new Comparable[newSize];
        for (int i = 1; i <= N; i++) {
            newAr[i] = ar[i];
        }
        ar = newAr;
    }

    private void swim(int n) {
        while (n > 1 && less(n / 2, n)) {
            exch(n, n / 2);
            n = n / 2;
        }
    }

    public Comparable delMax() {
        Comparable max = ar[1];
        exch(1, N--);
        ar[N + 1] = null;
        sink(1);
        return max;
    }

    private void sink(int top) {
        while (top * 2 <= N) {
            int j = top * 2;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (less(j, top)) {
                return;
            }
            exch(top, j);
            top = j;
        }
    }

    public static void main(String[] args) {
        HeapMaxPriority h = new HeapMaxPriority();
        h.insert(2);
        h.insert(555);
        h.insert(8);
        h.insert(5);
        h.insert(8);
        h.insert(1);
        h.insert(23);
        System.out.println(h.delMax());
        System.out.println(h.delMax());
        System.out.println(h.delMax());
        System.out.println(h.delMax());
        System.out.println(h.delMax());
        System.out.println(h.delMax());
        System.out.println(h.delMax());
        System.out.println(h.delMax());
    }

    private void exch(int n, int i) {
        Comparable temp = ar[n];
        ar[n] = ar[i];
        ar[i] = temp;
    }

    public boolean less(int a, int b) {
        return ar[a].compareTo(ar[b]) < 0;
    }
}
