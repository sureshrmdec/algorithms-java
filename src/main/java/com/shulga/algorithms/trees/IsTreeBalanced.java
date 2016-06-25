package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 6/21/16.
 */
public class IsTreeBalanced {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        System.out.println(new IsTreeBalanced().run(root));
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private boolean run(Node node) {
        return Math.abs(height(node.left) - height(node.right)) <= 1;
    }

    static class Node {
        Node left;
        Node right;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }
}
