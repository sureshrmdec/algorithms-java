package com.shulga.algorithms.permutations;

import java.util.Random;

/**
 * Created by eugene on 9/6/16.
 */
public class RandomNodeInLinkedList {
    static class Node {
        Node(int data) {
            this.data = data;
        }

        Node next;
        int data;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(12);
        node.next.next = new Node(13);
        node.next.next.next = new Node(14);
        node.next.next.next.next = new Node(19);
        new RandomNodeInLinkedList().run(node);
    }

    private void run(Node node) {
        Node current = node;
        Random r = new Random();
        Node res = node;
        for (int n = 2; current != null; n++) {
            if (r.nextInt(n) % n == 0) {
                res = current;
            }
            current = current.next;
        }
        System.out.println(res.data);
    }
}
