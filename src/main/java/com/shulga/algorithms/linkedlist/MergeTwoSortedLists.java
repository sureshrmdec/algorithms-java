package com.shulga.algorithms.linkedlist;

/**
 * Created by eshulga on 6/15/16.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(4);
        node1.next.next = new Node(6);
        node1.next.next.next = new Node(7);

        Node node2 = new Node(2);
        node2.next = new Node(3);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(8);
        node2.next.next.next.next = new Node(9);

        Node run = new MergeTwoSortedLists().run(node1, node2);
        while (run != null) {
            System.out.println(run.data);
            run = run.next;
        }
    }

    private Node run(Node headA, Node headB) {
        Node res = null;
        Node first = null;
        Node currentA = headA;
        Node currentB = headB;
        while (currentA != null || currentB != null) {
            Node newNode;
            if (currentB == null) {
                newNode = new Node();
                newNode.data = currentA.data;
                currentA = currentA.next;
            } else if (currentA == null) {
                newNode = new Node();
                newNode.data = currentB.data;
                currentB = currentB.next;
            } else if (currentA.data < currentB.data) {
                newNode = new Node();
                newNode.data = currentA.data;
                currentA = currentA.next;
            } else {
                newNode = new Node();
                newNode.data = currentB.data;
                currentB = currentB.next;
            }
            if (first == null) {
                first = newNode;
                res = newNode;
            } else {
                res.next = newNode;
                res = res.next;
            }
        }
        return first;
    }

    static class Node {
        Node next;
        int data;
        Node(){}
        Node(int data){
            this.data = data;
        }
    }
}
