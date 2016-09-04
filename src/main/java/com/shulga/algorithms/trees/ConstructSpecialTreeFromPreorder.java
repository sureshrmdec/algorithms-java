package com.shulga.algorithms.trees;

/**
 * Construct a special tree from given preorder traversal
 * Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary tree where every node has either 0 or 2 children.
 * One more array ‘preLN[]’ is given which has only two possible values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]’ indicates that the
 * corresponding node in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node is non-leaf node. Write a
 * function to construct the tree from the given two arrays.
 * <p>
 * Source: Amazon Interview Question
 * <p>
 * Example:
 * <p>
 * Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
 * Output: Root of following tree
 * 10
 * /    \
 * 30   15
 * /     \
 * 20     5
 * The first element in pre[] will always be root. So we can easily figure out root. If left subtree is empty,
 * the right subtree must also be empty and preLN[] entry for root must be ‘L’. We can simply create a node and return it.
 * If left and right subtrees are not empty, then recursively call for left and right subtrees and link the returned nodes to root.
 */
public class ConstructSpecialTreeFromPreorder {
    public static void main(String[] args) {
        ConstructSpecialTreeFromPreorder tree = new ConstructSpecialTreeFromPreorder();
        Node node = tree.constructTree(new int[]{10, 30, 20, 5, 15, 11, 9}, new int[]{'N', 'N', 'L', 'L', 'N', 'L', 'L'}, new Counter());
        tree.preorder(node);

        node = tree.constructTree2(new int[]{10, 30, -1, -1, 15, -1, -1}, new Counter());
        tree.preorder(node);
    }

    public Node constructTree(int[] pre, int[] preLN, Counter c) {
        if (c.counter == pre.length) return null;
        Node node = new Node();
        node.data = pre[c.counter];
        if (preLN[c.counter] == 'N') {
            c.counter++;
            node.left = constructTree(pre, preLN, c);
            c.counter++;
            node.right = constructTree(pre, preLN, c);
        }
        return node;
    }

    public void preorder(Node node) {
        if (node == null) return;
        System.out.println(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    private Node constructTree2(int[] ints, Counter counter) {
        if (counter.counter == ints.length || ints[counter.counter] == -1) {
            return null;
        }
        Node node = new Node();
        node.data = ints[counter.counter];
        counter.counter++;
        node.left = constructTree2(ints, counter);
        counter.counter++;
        node.right = constructTree2(ints, counter);
        return node;
    }

    static class Counter {
        int counter = 0;
    }

    private class Node {
        Node left, right;
        int data;
    }
}
