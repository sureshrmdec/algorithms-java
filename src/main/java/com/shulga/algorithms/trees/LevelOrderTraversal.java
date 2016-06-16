package com.shulga.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eshulga on 6/15/16.
 */
public class LevelOrderTraversal {
    static class Node {
        Node left;
        Node right;
        int data;
        Node(){}
        Node(int data){
            this.data=data;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(15);
        node.left.left = new Node(3);
        node.left.right= new Node(7);
        new LevelOrderTraversal().LevelOrder(node);
    }

    static void LevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left!=null) {
                queue.add(node.left);
            }
            if(node.right!=null) {
                queue.add(node.right);
            }
        }
    }


}
