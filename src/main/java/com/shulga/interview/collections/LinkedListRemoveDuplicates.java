package com.shulga.interview.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ievgen on 10/9/2014.
 */
public class LinkedListRemoveDuplicates {

    public static void removeDuplicatesExtraMemory(LinkedListNode node) {
        Set set = new HashSet();
        LinkedListNode current = node;
        LinkedListNode previous = null;

        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public static void removeDuplicates(LinkedListNode node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        LinkedListNode current = node;
        LinkedListNode previous = null;
        while (current != null) {
            LinkedListNode runner = node;
            while (runner.data != current.data) {
                runner = runner.next;
            }
            if (current != runner) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode();
        node = node.fill(1, 1, 1, 2, 3, 5, 6, 8, 9, 4, 4, 4);
        removeDuplicates(node);
        node.print();
    }
}
