package com.shulga.algorithms.linkedlist;

/**
 * Created by eugene on 2/13/16.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList cl = new ReverseLinkedList();
        Node node = new Node(1);
        node.next = new Node(85);
        node.next.next = new Node(15);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(20);
        System.out.println();
        Node reverse = cl.reverse(node);
        cl.print(reverse);
    }

    void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    Node reverse(Node node) {
        Node current = node;
        Node prev = null;
        Node temp;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    static class Node {
        Node next;
        int data;

        Node(int n) {
            data = n;
        }
    }
}
