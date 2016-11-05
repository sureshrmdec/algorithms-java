package com.shulga.co.ch2;

/**
 * Created by ievgen on 10/6/2014.
 */
public class LinkedStack<Item> {
    private Node first;

    public void push(Item item) {
        Node newNode = new Node();
        newNode.value = item;
        newNode.next = first;
        first = newNode;
    }

    public Item pop() {
        Item temp = first.value;
        first = first.next;
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        Item value;
        Node next;
    }
}
