package com.shulga.algorithms.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 9/5/16.
 */
public class RangeLookupProblem {
    static class Node {
        public Node(int key, int size) {
            this.key = key;
            this.size = size;
        }

        public Node() {
        }

        Node left;
        Node right;
        int key;
        int size;
    }

    public static void main(String[] args) {
        Node root = new Node(20, 6);
        root.left = new Node(10, 4);
        root.right = new Node(50, 0);
        root.left.left = new Node(5, 2);
        root.left.right = new Node(13, 0);
        root.left.left.left = new Node(3, 1);
        root.left.left.left.right = new Node(4, 0);
        System.out.println(new RangeLookupProblem().rangeLookup(root, 0, 5));
        List<Integer> res = new ArrayList<>();
        new RangeLookupProblem().rangeLookupElements(root, 0, 5, res);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(new RangeLookupProblem().select(root,4).key);
    }

    private void rangeLookupElements(Node node, int s, int e, List<Integer> res) {
        if(node==null) return;
        if(node.key>=s && node.key<=e){
            rangeLookupElements(node.left,s,e,res);
            res.add(node.key);
            rangeLookupElements(node.right,s,e,res);
        }else if(node.key<s){
            rangeLookupElements(node.right,s,e,res);
        }else if(node.key>e){
            rangeLookupElements(node.left,s,e,res);
        }
    }

    private int rangeLookup(Node node, int s, int e) {
        int startRank = rank(node, s);
        int endRank = rank(node, e);
        return endRank - startRank;
    }

    private int rank(Node node, int key) {
        if (node == null) {
            return 0;
        }
        int cmp = Integer.compare(key, node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        } else if (cmp > 0) {
            return 1 + node.size + rank(node.right, key);
        } else {
            return node.size;
        }
    }

    private Node select(Node node,int k){
        if(node==null) return null;
        int size  = node.size;
        if(size>k){
            return select(node.left,k);
        }else if(size<k){
            return select(node.right,k-1-node.size);
        }else{
            return node;
        }
    }
}
