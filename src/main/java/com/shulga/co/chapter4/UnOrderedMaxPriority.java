package com.shulga.co.chapter4;

/**
 * Created by ievgen on 10/7/2014.
 */
public class UnOrderedMaxPriority<Item extends Number> {
    private Item[] ar;
    private int N;

    public UnOrderedMaxPriority() {
        ar = (Item[]) new Object[20];
    }

    public void insert(Item item) {
        ar[N++] = item;
    }

    public Item removeMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (ar[i].intValue() > max) max = i;
        }
        exch(N - 1, max);
        return ar[--N];
    }

    private void exch(int i, int j) {
        Item temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
