package com.shulga.algorithms.stack;

import java.util.Iterator;

public class StackLinkedList<T> implements Stack<T>, Iterable<T> {
    private Node first;

    private class Node {
        T data;
        Node next;
    }

    @Override
    public void push(T data) {
        Node oldNode = first;
        Node newNode = new Node();
        newNode.data = data;
        first = newNode;
        first.next = oldNode;
    }

    @Override
    public T pop() {
        T temp = first.data;
        first = first.next;
        return temp;
    }

    @Override
    public T peek() {
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T temp = current.data;
            current = current.next;
            return temp;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
