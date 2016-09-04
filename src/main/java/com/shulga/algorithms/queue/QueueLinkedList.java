package com.shulga.algorithms.queue;

public class QueueLinkedList<T> implements Queue<T> {
    private Node first;
    private Node last;

    private class Node {
        T data;
        Node next;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(T data) {
        Node oldLast = last;
        last = new Node();
        last.data = data;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    @Override
    public T dequeue() {
        T temp = first.data;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return temp;
    }
}
