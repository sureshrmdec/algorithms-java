package com.shulga.coursera.algorithms1.chapter2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ievgen on 10/6/2014.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int front = 0;
    private int rear = -1;
    private int N;

    public RandomizedQueue() {
        arr = (Item[]) new Object[71];
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("Size: " + queue.size());

        for (Integer item : queue) {
            System.out.println(item);
        }

        System.out.println("=============");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("=============");
        System.out.println("Size: " + queue.size());
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
        int index = getRandom();
        Item temp = arr[index];
        rearrange(index, rear);
        arr[rear] = null;
        rear--;
        N--;
        return temp;
    }

    private int getRandom() {
        return (int) (Math.random() * 100) % N;
    }

    private void rearrange(int index, int rear) {
        for (int i = index; i <= rear; i++) {
            arr[i] = arr[i + 1];
        }
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty data structure");
        }
    }

    public Item sample() {
        checkIfEmpty();
        return arr[getRandom()];
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator(arr, front, N);
    }

    private class QueueIterator implements Iterator<Item> {
        private Item[] ar;
        private int front;
        private int count;

        public QueueIterator(Item[] arr, int front, int count) {
            this.ar = arr;
            this.front = front;
            this.count = count;
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            if (count == 0) {
                throw new NoSuchElementException("No Element");
            }
            count--;
            return ar[front++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }
}
