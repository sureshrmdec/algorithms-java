package com.shulga.trees;

/**
 Check whether a binary tree is a full binary tree or not
 A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. Conversely,
 there is no node in a full binary tree, which has one child node. More information about full binary trees can be found here.
 */
public class CheckIfTreeisFull {

    private static class Node{
        Node(int data){
            this.data=data;
        }
        Node left,right;
        int data;
    }
    public boolean isFull(Node root) {
        if(root==null) return true;
        if((root.left==null && root.right!=null) || (root.right==null&& root.left!=null)){
            return false;
        }
        boolean left = isFull(root.left);
        if(left){
            return isFull(root.right);
        }
        return left;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //root.left.left = new Node(4);
        root.left.right = new Node(5);
        CheckIfTreeisFull l = new CheckIfTreeisFull();
        System.out.println(l.isFull(root));
    }
}
