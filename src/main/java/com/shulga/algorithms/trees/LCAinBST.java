package com.shulga.algorithms.trees;

/**
 * Lowest Common Ancestor in a Binary Search Tree.
 * Given values of two nodes in a Binary Search Tree, write a c program to find the Lowest Common Ancestor (LCA).
 * You may assume that both the values exist in the tree.
 * <p>
 * The function prototype should be as follows:
 * <p>
 * struct node *lca(node* root, int n1, int n2)
 * n1 and n2 are two given values in the tree with given root.
 */
public class LCAinBST {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        LCAinBST l = new LCAinBST();
        System.out.println(l.findLCA(root, 8, 14));
        System.out.println(l.findLCA(root, 10, 14));
    }

    public int findLCA(Node node, int i, int j) {
        if (node.data > i && node.data > j) {
            return findLCA(node.left, i, j);
        } else if (node.data < i && node.data < j) {
            return findLCA(node.right, i, j);
        } else {
            return node.data;
        }
    }
    public int height(NodeWithParent node) {
        int counter = 0;
        while(node.parent!=null){
            counter++;
        }
        return counter+1;
    }

    public NodeWithParent findLCAWithParent(NodeWithParent node1,NodeWithParent node2) {
        int height1 = height(node1);
        int height2 = height(node2);
        NodeWithParent bigger = null;
        NodeWithParent smaller;
        int diff;
        if(height1>height2){
            bigger = node1;
            smaller = node2;
            diff = height1-height2;
        }else{
            bigger = node2;
            smaller = node1;
            diff = height2-height1;
        }
        for (int i = 0; i < diff; i++) {
            bigger = bigger.parent;
        }
        for (int i = 0; i < Math.min(height1,height2); i++) {
            smaller = smaller.parent;
            bigger = bigger.parent;
        }
        return smaller;
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    private static class NodeWithParent {
        NodeWithParent left;
        NodeWithParent right;
        NodeWithParent parent;
        int data;

        NodeWithParent(int data) {
            this.data = data;
        }
    }


}
