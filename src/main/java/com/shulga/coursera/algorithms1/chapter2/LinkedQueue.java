package com.shulga.coursera.algorithms1.chapter2;

import java.util.Iterator;

/**
 * Created by ievgen on 10/6/2014.
 */
public class LinkedQueue<Item> implements Iterable {
    private Node first;
    private Node last;

    public void enqueue(Item item) {
        Node oldLast = last;
        Node newNode = new Node();
        newNode.value = item;
        last = newNode;
        if (first == null) {
            first = last;
        } else {
            oldLast.next = newNode;
        }
    }

    public Item dequeue() {
        Item temp = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return temp;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator {
        private Node current;

        public ListIterator(Node first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Item temp = current.value;
            current = current.next;
            return temp;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    private class Node {
        Node next;
        Item value;
    }
}
