package com.shulga.interview.collections;

/**
 * Created by ievgen on 10/10/2014.
 */
public class LinkedListNthToLast {

    public static LinkedListNode nthToLast(LinkedListNode node, int n) {
        LinkedListNode current = node;
        LinkedListNode nthCurrent = node;
        int counter = 0;
        while (current != null && counter < n) {
            current = current.next;
        }
        if (counter != n) {
            return null;
        }
        while (current != null) {
            current = current.next;
            nthCurrent = nthCurrent.next;
        }
        return nthCurrent;
    }

    public static void main(String[] args) {

    }
}
