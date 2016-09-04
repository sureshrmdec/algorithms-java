package com.shulga.algorithms.linkedlist;

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

    public static void removeDuplicates2(LinkedListNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Empty list");
        }
        LinkedListNode current = node;
        while (current != null) {
            LinkedListNode runner = current.next;
            LinkedListNode runnerPrev = current;
            boolean next = true;
            while (runner != null) {
                if (runner.data == runnerPrev.data) {
                    runnerPrev.next = runner.next;
                } else {
                    if (next) {
                        current = runnerPrev;
                        next = false;
                    }
                    runnerPrev = runner;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }

    public static void removeDuplicates3(LinkedListNode node) {
        LinkedListNode current = node;
        LinkedListNode prev = null;
        while (current != null) {
            LinkedListNode runner = node;
            while (runner.data != current.data) {
                runner = runner.next;
            }
            if (runner != current) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode();
        node = node.fill(1, 1, 1, 2, 3, 5, 6, 8, 9, 4, 4, 4);
        removeDuplicates(node);
        node.print();
        System.out.println();
        node = node.fill(1, 1, 1, 2, 3, 5, 6, 8, 9, 4, 4, 4);
        removeDuplicates2(node);
        node.print();
        //remove dups from sorted LL
        System.out.println("==========");
        node = new LinkedListNode();
        node = node.fill(1, 1, 1, 2, 3, 5, 6, 8, 9, 9);
        removeDuplicatesFromSortedLL(node);
        node.print();
    }

    public static void removeDuplicatesFromSortedLL(LinkedListNode node) {
        LinkedListNode current = node.next;
        LinkedListNode prev = node;
        while (current != null) {
            if (prev.data == current.data) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

}
