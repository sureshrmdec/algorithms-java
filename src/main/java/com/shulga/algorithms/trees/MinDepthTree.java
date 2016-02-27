package com.shulga.algorithms.trees;

/**
 Find Minimum Depth of a Binary Tree
 Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from root node down to the nearest leaf node.

 For example, minimum height of below Binary Tree is 2.
 */
public class MinDepthTree {

    public boolean isFull(Node root) {
        if(root==null) return true;
        if(root.left==null || root.right==null){
            return false;
        }
        boolean left = isFull(root.left);
        if(left){
            return isFull(root.right);
        }
        return left;
    }

    private static class Node{
        Node(int data){
            this.data=data;
        }
        Node left,right;
        int data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        MinDepthTree l = new MinDepthTree();
        System.out.println(l.minimumDepth(root));
    }

    private int minimumDepth(Node root) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left != null)
            return minimumDepth(root.right) + 1;

        // If right subtree is NULL, recur for right subtree
        if (root.right != null)
            return minimumDepth(root.left) + 1;

        return Math.min(minimumDepth(root.left), minimumDepth(root.right)) + 1;

    }
}
