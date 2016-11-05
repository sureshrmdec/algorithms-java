package com.shulga.algorithms.trees;

/**
 * Created by eugene on 9/13/16.
 */
public class RemoveNodesOnRootLeavePathBiggerK {

    private static class Node {
        Node left, right;
        int data;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //root.left.left = new Node(4);
        root.left.right = new Node(5);
        Node remove = new RemoveNodesOnRootLeavePathBiggerK().remove(root, 0, 1);
        System.out.println(remove);
    }

    private Node remove(Node node,int depth,int k) {
        if(node==null) return null;
        node.left = remove(node.left,depth+1,k);
        node.right = remove(node.right,depth+1,k);
        if(depth>k){
            return null;
        }
        return node;
    }
}
