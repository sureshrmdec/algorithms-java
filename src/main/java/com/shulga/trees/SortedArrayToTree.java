package com.shulga.trees;

/**
 Sorted Array to Balanced BST
 Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.

 Examples:

 Input:  Array {1, 2, 3}
 Output: A Balanced BST
 2
 /  \
 1    3

 Input: Array {1, 2, 3, 4}
 Output: A Balanced BST
 3
 /  \
 2    4
 /
 1
 */
public class SortedArrayToTree {
    private static Node root;
    private class Node{
        Node left,right;
        int data;
    }

    public Node sortedArrayToBST(int[] A, int s,int e){
        if(s>e){
            return null;
        }
        int mid = s+(e-s)/2;
        Node node = new Node();
        node.data = A[mid];
        node.left = sortedArrayToBST(A,s,mid-1);
        node.right = sortedArrayToBST(A,mid+1,e);
        return node;
    }

    public static void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }



    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3,4,5,6,7};
        SortedArrayToTree s = new SortedArrayToTree();
        root = s.sortedArrayToBST(ar,0,ar.length-1);
        preorder(root);
    }
}
