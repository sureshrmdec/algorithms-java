package com.shulga.algorithms.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ievgen on 9/28/2014.
 */
public class SingleLinkedList<Item> implements Iterable<Item> {
    private int N;
    private Node<Item> first;

    private class Node<Item> {
        private Node<Item> next;
        private Item item;

        private Node(Item item) {
            this.item = item;
        }
    }

    public SingleLinkedList() {
        N = 0;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldNode = first;
        first = new Node(item);
        first.next = oldNode;
        N++;
    }

    public boolean remove(Item item) {
        Node current = first;
        Node previous = first;
        while (current != null) {
            if (current.item.equals(item)) {
                previous.next = current.next;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator<Item>(first);
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        singleLinkedList.add(5);
        singleLinkedList.add(6);

        for (Integer item : singleLinkedList) {
            System.out.println(item);
        }

        singleLinkedList.remove(3);
        singleLinkedList.remove(1);
        singleLinkedList.add(7);

        System.out.println("After removing");
        for (Integer item : singleLinkedList) {
            System.out.println(item);
        }

    }

    private class LinkedListIterator<Item> implements Iterator<Item> {
        private Node first;

        LinkedListIterator(Node<Item> first) {
            this.first = first;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<Item> current = first;
            first = first.next;
            return current.item;
        }

        @Override
        public void remove() {

        }
    }
}
