package com.shulga.coursera.algorithms1.chapter4;

/**
 * Created by ievgen on 10/7/2014.
 */
public class OrderedMaxPriority<Item> {
    private Item[] ar;
    private int N;

    public OrderedMaxPriority() {
        ar = (Item[]) new Object[20];
    }

    public void insert(Item item) {
        //TODO
    }

    public Item removeMax() {
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
