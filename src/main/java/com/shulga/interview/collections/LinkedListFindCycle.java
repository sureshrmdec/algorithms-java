package com.shulga.interview.collections;

/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 * Created by ievgen on 10/11/2014.
 */
public class LinkedListFindCycle {

    public LinkedListNode findCycleStart(LinkedListNode node) {
        LinkedListNode n1 = node;
        LinkedListNode n2 = node;

        while (n2 != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                break;
            }
        }
        if (n2 == null) {
            return null;
        }
        n1 = node;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
