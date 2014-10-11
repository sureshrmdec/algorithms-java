package com.shulga.interview.collections;

/**
 * Created by ievgen on 10/9/2014.
 */
public class LinkedListNode<Item> {
    LinkedListNode next;
    Item data;

    public void addToTail(LinkedListNode node) {
        this.next = node;
    }

    public void print() {
        LinkedListNode current = this;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public LinkedListNode fill(Item... items) {
        LinkedListNode first = this;
        first.data = items[0];
        LinkedListNode current = first;
        for (int i = 1; i < items.length; i++) {
            current.next = new LinkedListNode();
            current.next.data = items[i];
            current = current.next;
        }
        return first;
    }


}
