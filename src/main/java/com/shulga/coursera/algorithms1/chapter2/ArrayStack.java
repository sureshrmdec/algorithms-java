package com.shulga.coursera.algorithms1.chapter2;

import java.util.Iterator;

/**
 * Created by ievgen on 10/6/2014.
 */
public class ArrayStack<Item> implements Iterable<Item> {
    private Item[] arr;
    private int nElement;

    public ArrayStack(int N) {
        arr = (Item[]) new Object[N];
    }

    public ArrayStack() {
        arr = (Item[]) new Object[20];
    }

    public void push(Item item) {
        if (nElement == arr.length) {
            resize(arr.length * 2);
        }
        arr[nElement++] = item;
    }

    public Item pop() {
        if (nElement == arr.length / 4) {
            resize(arr.length / 2);
        }
        return arr[--nElement];
    }

    public boolean isEmpty() {
        return nElement == 0;
    }

    private void resize(int newSize) {
        Item[] newArr = (Item[]) new
                Object[newSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(arr);
    }

    private class ListIterator implements Iterator {
        private Item[] arr;
        private int N;

        public ListIterator(Item[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean hasNext() {
            return N < arr.length;
        }

        @Override
        public Item next() {
            return arr[N++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }
}
