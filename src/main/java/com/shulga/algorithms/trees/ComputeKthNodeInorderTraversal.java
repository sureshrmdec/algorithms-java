package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 8/24/16.
 */
public class ComputeKthNodeInorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(10, 5);
        root.left = new Node(5, 4);
        root.right = new Node(20, 1);
        root.left.left = new Node(3, 2);
        root.left.left.left = new Node(1, 1);
        System.out.println(new ComputeKthNodeInorderTraversal().run(root, 2));
    }

    private Node run(Node node, int k) {
        if (node == null) return null;
        if (node.size == k) {
            return node;
        } else if (k < node.size) {
            return run(node.left, k);
        } else {
            return run(node.right, k - node.left.size - 1);
        }
    }

    static class Node {
        Node left;
        Node right;
        int data;
        int size;

        public Node(int data, int size) {
            this.data = data;
            this.size = size;
        }
    }
}
