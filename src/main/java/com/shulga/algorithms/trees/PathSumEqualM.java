package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 10/24/16.
 */
public class PathSumEqualM {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.left.right = new TreeNode(2);
        node.left.right.right = new TreeNode(1);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(-2);
        node.left.left.left = new TreeNode(3);
        node.right = new TreeNode(-3);
        node.right.right = new TreeNode(11);
        System.out.println(new PathSumEqualM().run(node, 8));
    }

    private int run(TreeNode node, int sum) {
        if (node == null) return 0;
        return runInternal(node, sum) + run(node.left, sum) + run(node.right, sum);
    }

    private int runInternal(TreeNode node, int sum) {
        if(node==null) return 0;
        int res = 0;
        if (sum == node.val) {
            res++;
        }
        res += runInternal(node.left, sum - node.val);
        res += runInternal(node.right, sum - node.val);
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
