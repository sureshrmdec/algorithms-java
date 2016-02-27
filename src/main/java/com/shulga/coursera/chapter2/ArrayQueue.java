package com.shulga.coursera.chapter2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ievgen on 10/6/2014.
 */
public class ArrayQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int front = 0;
    private int rear = -1;
    private int N;
    private int count;

    public ArrayQueue() {
        arr = (Item[]) new Object[71];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        for (Integer item : queue) {
            System.out.println(item);
        }

        System.out.println("=============");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("=============");
        for (Integer item : queue) {
            System.out.println(item);
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("Null element");
        }
        int length = arr.length - 1;
        if (N == length) {
            resize(length * 2);
        }
        if (rear == length) {
            rear = -1;
        }
        arr[++rear] = item;
        N++;
    }

    private void resize(int num) {
        Item[] newArr = (Item[]) new Object[num];
        for (int i = 0; i < N; i++) {
            newArr[i] = dequeue();
        }
        arr = newArr;
        front = 0;
        rear = N;
    }

    public Item dequeue() {
        checkIfEmpty();
        int length = arr.length;
        if (front == length) {
            front = 0;
        }
        Item temp = arr[front++];
        N--;
        return temp;
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty data structure");
        }
    }

    public Item sample() {
        checkIfEmpty();
        return arr[rear + 1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator(arr, front, N);
    }

    private class QueueIterator implements Iterator<Item> {
        private Item[] ar;
        private int front;
        private int count;

        public QueueIterator(Item[] arrmint, int front, int count) {
            ar = arrmint;
            this.front = front;
            this.count = count;
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            count--;
            return arr[front++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }
}
