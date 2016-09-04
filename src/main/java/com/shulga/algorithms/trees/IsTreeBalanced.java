package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 6/21/16.
 */
public class IsTreeBalanced {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        System.out.println(new IsTreeBalanced().run(root));
        System.out.println(new IsTreeBalanced().isBalanced(root).isBalanced);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private boolean run(Node node) {
        return Math.abs(height(node.left) - height(node.right)) <= 1;
    }

    BalanceStatusWithHeight isBalanced(Node node) {
        if (node == null) {
            return new BalanceStatusWithHeight(true, 0);
        }
        BalanceStatusWithHeight leftBalanced = isBalanced(node.left);
        if (!leftBalanced.isBalanced) {
            return leftBalanced;
        }
        BalanceStatusWithHeight rightBalanced = isBalanced(node.right);
        if (!rightBalanced.isBalanced) {
            return rightBalanced;
        }
        boolean isBalanced = Math.abs(leftBalanced.height - rightBalanced.height) <= 1;
        int height = Math.max(leftBalanced.height, rightBalanced.height) + 1;
        return new BalanceStatusWithHeight(isBalanced, height);
    }




    static class BalanceStatusWithHeight {
        boolean isBalanced;
        int height;
        public BalanceStatusWithHeight(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
