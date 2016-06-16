package com.shulga.algorithms.trees;

/**
 * You are given a description of a rooted tree. Your task is to compute and output its height. Recall
 * that the height of a (rooted) tree is the maximum depth of a node, or the maximum distance from a
 * leaf to the root. You are given an arbitrary tree, not necessarily a binary tree.
 * Input Format. The first line contains the number of vertices n.
 * The second line contains n integer numbers
 * from −1 to n − 1 — parents of vertices. If the i-th one of them (0 ≤ i ≤ n − 1) is −1, vertex i is the
 * root, otherwise it’s 0-based index of the parent of i-th vertex. It is guaranteed that there is exactly
 * one root. It is guaranteed that the input represents a tree.
 */
public class ConstructTreeFromArray {
    public static void main(String[] args) {
        int[] ar = {4, -1, 4, 1, 1};
        Node[] marked = new Node[ar.length];
        ConstructTreeFromArray constructTreeFromArray = new ConstructTreeFromArray();
        Node node = constructTreeFromArray.run(5, ar, marked);
        constructTreeFromArray.inorder(node);
    }

    private Node run(int N, int[] ar, Node[] marked) {
        Node root = null;
        for (int i = 0; i < ar.length; i++) {
            if (marked[i] != null) continue;
            Node prev = new Node(i);
            marked[i] = prev;
            int j = ar[i];
            int prevIndex = 0;
            while (j != -1) {
                Node parent = getNode(j, marked);
                addNode(parent, prev);
                prev = parent;
                prevIndex = j;
                j = ar[j];
            }
            if (root == null) {
                root = new Node(prevIndex);
            }
            addNode(root, prev);
        }
        return root;
    }

    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.key);
        inorder(node.right);

    }

    Node getNode(int j, Node[] marked) {
        if (marked[j] != null) {
            return marked[j];
        } else {
            Node node = new Node(j);
            marked[j] = node;
            return node;
        }
    }

    void addNode(Node node, Node child) {
        if (node.left == null) {
            node.left = child;
        } else if (node.right == null && node.left.key != child.key) {
            node.right = child;
        } else {
            System.out.println("Something went wrong");
        }
    }

    class Node {
        Node left;
        Node right;
        int key;

        Node(int key) {
            this.key = key;
        }
    }
}
