package com.shulga.algorithms.linkedlist;

/**
 * Created by eshulga on 6/8/16.
 */
public class InsetBeforeNElementFromTheEnd {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        insertBeforeNElement(node, 10, 3);
        print(node);
    }

    static void  print(Node node){
        while(node!=null){
            System.out.print(node.data +" ");
            node = node.next;
        }
    }

    private static void insertBeforeNElement(Node node, int key, int k) {
        Node current = node;
        Node previosTarget = null;
        Node target = node;
        int start = 0;
        while (current != null) {
            start++;
            current = current.next;
            if (start > k) {
                previosTarget = target;
                target = target.next;
            }
        }
        Node newNode = new Node(key);
        newNode.next = target;
        previosTarget.next = newNode;

    }

    static class Node {
        Node next;
        int data;
        Node(int data) {
            this.data = data;
        }
    }
}
