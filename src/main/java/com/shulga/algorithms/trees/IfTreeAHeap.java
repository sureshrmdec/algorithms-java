package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 6/7/16.
 */
public class IfTreeAHeap {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(8);
        new IfTreeAHeap().run(root);
    }

    private boolean run(Node node) {
        return false;
    }

    int isFull(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        if (node.left != null && node.right != null) {
            return isFull(node.left) + isFull(node.right);
        }

        return 0;
    }

    static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
        }
    }
}
