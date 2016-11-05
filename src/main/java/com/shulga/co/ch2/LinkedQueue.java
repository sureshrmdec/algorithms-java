package com.shulga.co.ch2;

import java.util.Iterator;

/**
 * Created by ievgen on 10/6/2014.
 */
public class LinkedQueue<Item> implements Iterable {
    Node first;
    private Node last;

    public static void main(String[] args) {
        LinkedQueue<Integer> q = new LinkedQueue<>();
        q.enqueue(1);
        q.enqueue(7);
        q.enqueue(5);
        q.enqueue(2);
        q.enqueue(9);
        q.enqueue(0);
        System.out.println(q.max(q.first, 0));
    }

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

    public int max(Node node, int max) {
        if (node == null) return max;
        if (Integer.valueOf(node.value.toString()) > max) return max(node.next, Integer.valueOf(node.value.toString()));
        else return max(node.next, max);
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

    class Node {
        Node next;
        Item value;
    }
}
