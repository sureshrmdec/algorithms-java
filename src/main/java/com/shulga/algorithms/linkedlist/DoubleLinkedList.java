package com.shulga.algorithms.linkedlist;

/**
 * Created by eshulga on 6/7/16.
 */
public class DoubleLinkedList {
    Node head;
    Node tail;

    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addFirst(3);
        list.addFirst(1);
        list.addAfter(1, 2);
        list.addAfter(3, 4);
        list.addBefore(1, 0);
        list.addBefore(2, 10);
        list.iterateForward();
    }

    void addAfter(int key,int newKey) {
        if (isEmpty()) return;
        Node current = head;
        while (current.data != key) {
            current = current.next;
        }
        Node newNode = new Node(newKey);
        if (current.next != null) {
            current.next.prev = newNode;
            newNode.next = current.next;
        }else{
            tail = newNode;
        }
        newNode.prev = current;
        current.next = newNode;
    }

    void iterateForward(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    void addBefore(int key,int newKey) {
        if (isEmpty()) return;
        Node current = head;
        while (current.data != key) {
            current = current.next;
        }
        Node newNode = new Node(newKey);
        if(current.prev!=null){
            current.prev.next = newNode;
            newNode.prev = current.prev;
        }else{
            head = newNode;
        }
        newNode.next = current;
        current.prev = newNode;
    }

    int popLast() {
        if (isEmpty()) return -1;
        Node temp = tail;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return temp.data;
    }

    int popFirst() {
        if (isEmpty()) return -1;
        Node temp = head;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return temp.data;
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    private class Node {
        Node next;
        Node prev;
        int data;
        Node(int data) {
            this.data = data;
        }
    }

}
