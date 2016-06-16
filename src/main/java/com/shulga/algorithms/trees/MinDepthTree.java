package com.shulga.algorithms.trees;

/**
 * Find Minimum Depth of a Binary Tree
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path
 * from root node down to the nearest leaf node.
 * <p>
 * For example, minimum height of below Binary Tree is 2.
 */
public class MinDepthTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(4);
        root.right.left = new Node(3);
        root.right.right = new Node(5);
        MinDepthTree l = new MinDepthTree();
        System.out.println(l.minDepth(root));
    }

    public int minDepth(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public boolean isFull(Node root) {
        if (root == null) return true;
        if (root.left == null || root.right == null) {
            return false;
        }
        boolean left = isFull(root.left);
        if (left) {
            return isFull(root.right);
        }
        return left;
    }

    private static class Node {
        Node left, right;
        int data;
        Node(int data) {
            this.data = data;
        }
    }
}
