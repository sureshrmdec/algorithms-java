package com.shulga.algorithms.trees;

/**
 * Construct BST from given preorder traversal | Set 1
 * Given preorder traversal of a binary search tree, construct the BST.
 * <p>
 * For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.
 * <p>
 * 10
 * /   \
 * 5     40
 * /  \      \
 * 1    7      50
 * <p>
 * Method 1 ( O(n^2) time complexity )
 * The first element of preorder traversal is always root. We first construct the root. Then we find the index of first element which is greater than root. Let the index be ‘i’. The values between root and ‘i’ will be part of left subtree, and the values between ‘i+1′ and ‘n-1′ will be part of right subtree. Divide given pre[] at index “i” and recur for left and right sub-trees.
 * For example in {10, 5, 1, 7, 40, 50}, 10 is the first element, so we make it root. Now we look for the first element greater than 10, we find 40. So we know the structure of BST is as following.
 */
public class ConstructBstFromPreorderTraversal {
    private class Node {
        Node left, right;
        int data;
    }

    public Node constructBst(int[] A, int s, int e, int counter) {
        if (e < s) return null;
        Node root = new Node();
        root.data = A[s];
        int i;
        for (i = s; i <= e; i++) {
            if (root.data < A[i]) break;
        }
        root.left = constructBst(A, s + 1, i - 1, counter);
        root.right = constructBst(A, i, e, counter);
        return root;
    }

    public void preorder(Node node) {
        if (node == null) return;
        System.out.println(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        ConstructBstFromPreorderTraversal tree = new ConstructBstFromPreorderTraversal();
        int[] ar = {10, 5, 1, 7, 40, 50};
        Node root = tree.constructBst(ar, 0, ar.length - 1, 0);
        tree.preorder(root);
    }
}
