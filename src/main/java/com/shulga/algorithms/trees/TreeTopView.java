package com.shulga.algorithms.trees;

import java.util.*;

/**
 * Print Nodes in Top View of Binary Tree
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it.
 * The output nodes can be printed in any order. Expected time complexity is O(n)
 * <p>
 * A node x is there in output if x is the topmost node at its horizontal distance. Horizontal distance of left child of a node x is equal
 * to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
 * <p>
 *      1
 *   /     \
 *  2       3
 * /  \    / \
 * 4    5  6   7
 * Top view of the above binary tree is
 * 4 2 1 3 7
 * <p>
 * 1
 * /   \
 * 2       3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * Top view of the above binary tree is
 * 2 1 3 6
 */
public class TreeTopView {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);

        System.out.println("vertical order traversal is :");
        topView(tree.root);
    }

    static class Pair{
         Pair(int hd, Node node){
            this.hd=hd;
            this.node=node;
        }
        int hd;
        Node node;
    }

    static void topView(Node root) {

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Node> hashMap = new TreeMap<>();
        queue.add(new Pair(0,root));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (poll.node.left != null) {
                queue.add(new Pair(poll.hd - 1,poll.node.left));
            }
            if (poll.node.right != null) {
                queue.add(new Pair(poll.hd + 1,poll.node.right));
            }
            if (!hashMap.containsKey(poll.hd)) {
                hashMap.put(poll.hd, poll.node);
            }
        }
        for (Node entry:hashMap.values()){
            System.out.print(entry.data + " ");
        }

    }

    private void findLeft(Node node, LinkedList list, int minHD) {
        list.add(node);
        if (node.left == null) {
            return;
        }
        findLeft(node.left, list, minHD);
    }

    static class Node {
        int data;
        Node left, right;
        Node() {}
        Node(int data) {
            this.data = data;
        }
    }

    static class Values {
        int max, min;
    }

    static class BinaryTree {
        static Node root;
        Values val = new Values();

        void findMinMax(Node node, Values min, Values max, int hd) {

            // Base case
            if (node == null)
                return;

            // Update min and max
            if (hd < min.min)
                min.min = hd;
            else if (hd > max.max)
                max.max = hd;

            // Recur for left and right subtrees
            findMinMax(node.left, min, max, hd - 1);
            findMinMax(node.right, min, max, hd + 1);
        }

        // A utility function to print all nodes on a given line_no.
        // hd is horizontal distance of current node with respect to root.
        void printVerticalLine(Node node, int line_no, int hd) {

            // Base case
            if (node == null)
                return;

            // If this node is on the given line number
            if (hd == line_no)
                System.out.print(node.data + " ");

            // Recur for left and right subtrees
            printVerticalLine(node.left, line_no, hd - 1);
            printVerticalLine(node.right, line_no, hd + 1);
        }

        // The main function that prints a given binary tree in
        // vertical order
        void verticalOrder(Node node) {

            // Find min and max distances with resepect to root
            findMinMax(node, val, val, 0);

            // Iterate through all possible vertical lines starting
            // from the leftmost line and print nodes line by line
            for (int line_no = val.min; line_no <= val.max; line_no++) {
                printVerticalLine(node, line_no, 0);
                System.out.println("");
            }
        }
    }
}
