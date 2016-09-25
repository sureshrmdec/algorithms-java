package com.shulga.algorithms.linkedlist;

/**
 * Created by eshulga on 7/7/16.
 */
public class CyclicRightShiftLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node run = new CyclicRightShiftLinkedList().run(node, 2);
        while (run != null) {
            System.out.print(run.data + " ");
            run = run.next;
        }
    }


    private Node run(Node node, int n) {
        Node first = node;
        Node current = node;
        Node currenttarget = node;
        int c = 0;
        Node localEnd = node;
        while (current != null) {
            if (c >= n) {
                localEnd = currenttarget;
                currenttarget = currenttarget.next;
            }
            current = current.next;
            c++;
        }
        Node newFirst = localEnd.next;
        current = newFirst;
        localEnd.next = null;
        while (current.next != null) {
            current = current.next;
        }
        current.next = first;
        return newFirst;
    }

    private static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
