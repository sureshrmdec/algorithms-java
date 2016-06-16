package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 6/15/16.
 */
public class LowerCommonAncestor {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(15);
        node.left.left = new Node(3);
        node.left.right = new Node(7);
        node.left.left.left = new Node(1);
        new LowerCommonAncestor().lca(node, 1, 7);
    }

    static Node lca(Node root, int v1, int v2) {
        if (v1 < root.data) {
            if (v2 > root.data) return root;
            return lca(root.left, v1, v2);
        } else if (v1 > root.data) {
            if (v2 < root.data) return root;
            return lca(root.right, v1, v2);
        } else {
            return root;
        }
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
