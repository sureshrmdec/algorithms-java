package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 3/22/16.
 */
public class CheckIfTreeIsSubtree {
    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.left.left = new Node(1);
        node.left.left.right = new Node(2);

        Node subtree = new Node(1);
        subtree.right = new Node(2);
        System.out.println(new CheckIfTreeIsSubtree().run(node, subtree));
    }

    boolean isIdentical2(Node node1,Node node2){
        if(node1==null && node2==null) return true;
        if(node1==null && node2==null){
            return false;
        }
        return node1.data==node2.data && isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right);
    }

    private boolean run(Node node, Node subtree) {
        if (node == null) {
            return false;
        }
        if (subtree == null) {
            return true;
        }
        if (isIdentical(node, subtree)) {
            return true;
        }
        return run(node.left, subtree) || run(node.right, subtree);
    }

    private boolean isIdentical(Node node, Node subtree) {
        if (subtree == null && node == null) {
            return true;
        }
        if (subtree == null || node == null) {
            return false;
        }
        return node.data == subtree.data && isIdentical(node.left, subtree.left) && isIdentical(node.right, subtree.right);
    }

    static class Node {
        Node left, right;
        int data;
        Node(int n) {
            data = n;
        }
    }
}
