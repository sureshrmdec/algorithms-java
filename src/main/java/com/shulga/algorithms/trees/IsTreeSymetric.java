package com.shulga.algorithms.trees;

import java.util.LinkedList;

/**
 * Created by eshulga on 6/21/16.
 */
public class IsTreeSymetric {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(15);
        node.left.left = new Node(3);
        node.left.right = new Node(7);
        node.left.left.left = new Node(1);
//        System.out.println(new IsTreeSymetric().isSymetric(node));

        Node node2 = new Node(10);
        node2.left = new Node(3);
        node2.right = new Node(5);
        node2.left.left = new Node(3);
        node2.right.right = new Node(10);
        System.out.println(new IsTreeSymetric().isSymetric(node2));
        System.out.println(new IsTreeSymetric().isSymetricIdentical(node2.left, node2.right));
    }

    public void preorder(Node node, LinkedList<Node> queue, boolean check) {
        if (node == null) return;
        if (check) {
            if (queue.peek().data != node.data) {
                queue.pop();
            }
        } else {
            queue.add(node);
        }
        preorder(node.left, queue, check);
        preorder(node.right, queue, check);
    }

    private boolean isSymetric(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        preorder(node.left, queue, false);
        preorder(node.right, queue, true);
        return queue.isEmpty();
    }

    public boolean isSymetricIdentical(Node node1, Node node2) {
        if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            return false;
        }
        if ((node1 == null && node2 == null) || node1.data == node2.data) {
            return true;
        }
        return isSymetricIdentical(node1.left, node2.right) && isSymetricIdentical(node1.right, node2.left);
    }

    static class Node {
        Node left;
        Node right;
        int data;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }
}
