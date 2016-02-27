package com.shulga.coursera.chapter2;

import java.util.Iterator;

/**
 * Created by eshulga on 2/12/16.
 */
public class ArrayQueue2<Item> implements Iterable<Item> {
    private Item[] arr;
    private int rear = -1;
    private int front = 0;

    public ArrayQueue2() {
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

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
