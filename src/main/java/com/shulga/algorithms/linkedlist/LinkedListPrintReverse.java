package com.shulga.algorithms.linkedlist;

/**
 * Created by eugene on 3/19/16.
 */
public class LinkedListPrintReverse {
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next= new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(5);
        new LinkedListPrintReverse().ReversePrint(node);
    }

    void ReversePrint(Node head) {
        if(head==null){
            return;
        }
        ReversePrint(head.next);
        System.out.println(head.data);
    }
}
