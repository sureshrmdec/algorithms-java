package com.shulga.algorithms.collections.adt;

import java.util.Iterator;

public class StackArray<T> implements Stack<T>, Iterable<T> {
    private T[] ar;
    private int nCount = 0;

    @SuppressWarnings("unchecked")
    public StackArray() {
        ar = (T[]) new Object[10];
    }

    @Override
    public void push(T data) {
        if (nCount == ar.length) {
            resize(2 * ar.length);
        }
        ar[nCount++] = data;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < nCount; i++) {
            copy[i] = ar[i];
        }
        ar = copy;
    }

    @Override
    public T pop() {
        if (nCount > 0 && nCount == ar.length / 4) {
            resize(ar.length / 2);
        }
        return ar[--nCount];
    }

    @Override
    public T peek() {
        return ar[nCount];
    }

    @Override
    public boolean isEmpty() {
        return nCount == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private int position;

        @Override
        public boolean hasNext() {
            return position < nCount;
        }

        @Override
        public T next() {
            return ar[position++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
