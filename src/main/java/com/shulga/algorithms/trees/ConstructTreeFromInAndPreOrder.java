package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 6/7/16.
 * <p>
 * Preorder traversal of binary tree is
 * 1 2 4 5 3
 * Inorder traversal of binary tree is
 * 4 2 5 1 3
 * Postorder traversal of binary tree is
 * 4 5 2 3 1
 */
public class ConstructTreeFromInAndPreOrder {
    // Java program to construct a tree using inorder and preorder traversal
    static Node root;
    static int preIndex = 0;
    static int preIndex2 = 0;

    // driver program to test above functions
    public static void main(String args[]) {
        ConstructTreeFromInAndPreOrder tree = new ConstructTreeFromInAndPreOrder();
        int pre[] = new int[]{1, 2, 4, 5, 3};
        int in[] = new int[]{4, 2, 5, 1, 3};
        int len = in.length;
        Node mynode = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(mynode);
    }

    Node buildTree(int inorder[], int preorder[], int inStrt, int inEnd) {
        if (inStrt > inEnd) {
            return null;
        }
        Node tNode = new Node(preorder[preIndex++]);

        /* If this node has no children then return */
        if (inStrt == inEnd) {
            return tNode;
        }

        /* Else find the index of this node inorder Inorder traversal */
        int inIndex = search(inorder, inStrt, inEnd, tNode.data);

        /* Using index inorder Inorder traversal, construct left and
         right subtress */
        tNode.left = buildTree(inorder, preorder, inStrt, inIndex - 1);
        tNode.right = buildTree(inorder, preorder, inIndex + 1, inEnd);

        return tNode;
    }

    Node buildTree2(int inorder[], int preorder[], int start, int end) {
        if(start>end){
            return null;
        }
        Node rNode = new Node(preorder[preIndex2]);
        if(start==end){
            return rNode;
        }

        int position  = search(inorder,start,end,rNode.data);
        rNode.left = buildTree2(inorder,preorder,start,position-1);
        rNode.right = buildTree2(inorder,preorder,position+1,end);
        return rNode;
    }

    /* UTILITY FUNCTIONS */
    /* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
    int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }

        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // A binary tree node
    class Node {

        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
