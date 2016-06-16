package com.shulga.algorithms.linkedlist;

/**
 * Created by eshulga on 6/15/16.
 */
public class CompareTwoLinkedLists {
    static class Node {
        Node next;
        int data;

        Node(int n) {
            data = n;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(4);
        node1.next.next = new Node(6);
        node1.next.next.next = new Node(7);

        Node node2 = new Node(2);
        node2.next = new Node(3);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(8);

        System.out.println(new CompareTwoLinkedLists().run(node1, node2));
    }

    private boolean run(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;
        while(currentA!=null || currentB!=null){
            if((currentA.next==null && currentB.next!=null) || (currentB.next==null && currentA.next!=null) || currentA.data!=currentB.data){
                return false;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return true;
    }
}
