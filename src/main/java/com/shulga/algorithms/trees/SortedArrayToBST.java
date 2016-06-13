package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 6/7/16.
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        Node run = sortedArrayToBST.run(ar, 0, ar.length-1);
        sortedArrayToBST.inorder(run);
    }

    private Node run(int[] ar, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        Node node = new Node(ar[mid]);
        node.left = run(ar, start, mid-1);
        node.right = run(ar, mid + 1, end);
        return node;
    }

    private void inorder(Node node){
        if(node==null) return;
        inorder(node.left);
        System.out.println(node.key);
        inorder(node.right);
    }

    class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
        }
    }
}
