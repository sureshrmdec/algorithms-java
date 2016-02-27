package com.shulga.coursera.chapter2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ievgen on 10/6/2014.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public Deque() {

    }

    public static void main(String[] args) {
        Deque<Integer> deck = new Deque<Integer>();
        deck.addFirst(3);
        deck.addFirst(2);
        deck.addFirst(1);
        deck.addLast(4);
        deck.addLast(5);
        System.out.println("Size: " + deck.size());
        deck.removeFirst();
        deck.removeFirst();
        deck.removeLast();
        System.out.println("Size: " + deck.size());

        for (Integer item : deck) {
            System.out.println(item);
        }
        System.out.println("=======================");
        Deque<Integer> deckReverse = new Deque<Integer>();
        deckReverse.addLast(4);
        deckReverse.addLast(5);
        deckReverse.addFirst(3);
        deckReverse.addFirst(2);
        deckReverse.addFirst(1);
        System.out.println("Size: " + deckReverse.size());
        deckReverse.removeLast();
        deckReverse.removeFirst();
        deckReverse.removeFirst();
        System.out.println("Size: " + deckReverse.size());

        for (Integer item : deck) {
            System.out.println(item);
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(Item item) {
        validateItem(item);
        Node newNode = new Node();
        newNode.value = item;
        newNode.next = first;

        if (first == null) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        first = newNode;
        N++;
    }

    private void validateItem(Item item) {
        if (item == null) {
            throw new NullPointerException("Null value");
        }
    }

    public void addLast(Item item) {
        validateItem(item);
        Node newNode = new Node();
        newNode.value = item;
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        N++;
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty data structure");
        }
    }

    public Item removeFirst() {
        checkIfEmpty();
        Item temp = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }
        N--;
        return temp;
    }

    public Item removeLast() {
        checkIfEmpty();
        Item temp = last.value;
        last = last.previous;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        N--;
        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeueIterator(first);
    }

    private class Node {
        Item value;
        Node next;
        Node previous;
    }

    private class DequeueIterator implements Iterator<Item> {
        private Node current;

        public DequeueIterator(Node first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("No element in iterator");
            }
            Item temp = current.value;
            current = current.next;
            return temp;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }
}
