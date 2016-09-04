package com.shulga.algorithms.sorting;

/**
 * Created by eshulga on 8/23/16.
 */
public class Merge2SortedLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(4);
        node.next.next = new Node(9);
        node.next.next.next = new Node(20);

        Node node1 = new Node(5);
        node1.next = new Node(6);
        node1.next.next = new Node(7);
        node1.next.next.next = new Node(9);
        node1.next.next.next.next = new Node(99);

        Node res = new Merge2SortedLinkedList().run(node, node1);
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }

    private Node run(Node node, Node node1) {
        Node res = new Node(Integer.MIN_VALUE);
        Node start = res;
        while (node != null || node1 != null) {
            if (node == null) {
                res.next = node1;
                node1 = node1.next;
            } else if (node1 == null ) {
                res.next = node;
                node = node.next;
            } else if(node1.data < node.data) {
                res.next = node1;
                node1 = node1.next;
            }else  {
                res.next = node;
                node = node.next;
            }
            res = res.next;
        }
        return start.next;
    }

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
}
