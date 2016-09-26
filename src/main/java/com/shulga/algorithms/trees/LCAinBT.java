package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 8/24/16.
 */
public class LCAinBT {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        LCAinBT l = new LCAinBT();
        System.out.println(l.lca(root, 4, 14).node.data);
    }

    private LCANode lca(Node tree, int node0, int node1) {
        if (tree == null) return new LCANode(null, 0);

        LCANode leftTree = lca(tree.left, node0, node1);
        if (leftTree.seenNodes == 2) {
            return leftTree;
        }

        LCANode rightTree = lca(tree.right, node0, node1);
        if (rightTree.seenNodes == 2) {
            return rightTree;
        }
        int seenNodes = rightTree.seenNodes + leftTree.seenNodes + tree.data == node1 ? 1 : 0 + tree.data == node0 ? 1 : 0;
        return new LCANode(seenNodes == 2 ? tree : null, seenNodes);
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static class LCANode {
        Node node;
        int seenNodes;

        public LCANode(Node node, int seenNodes) {
            this.node = node;
            this.seenNodes = seenNodes;
        }
    }
}
