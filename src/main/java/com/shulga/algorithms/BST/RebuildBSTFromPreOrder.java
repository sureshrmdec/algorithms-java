package com.shulga.algorithms.BST;

/**
 * Created by eugene on 9/4/16.
 */
public class RebuildBSTFromPreOrder {
    static class Counter {
        int c;
    }
    static class Node {
        public Node(int key) {
            this.key = key;
        }

        public Node() {
        }

        Node left;
        Node right;
        int key;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{43, 23, 37, 29, 31, 41, 47, 53};
        Node node = new RebuildBSTFromPreOrder().build(preOrder, 0, preOrder.length);
        new RebuildBSTFromPreOrder().inorder(node);
        System.out.println();
        new RebuildBSTFromPreOrder().preorder(node);

        System.out.println();
        System.out.println("Faster method");
        node = new RebuildBSTFromPreOrder().buildNTime(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE ,new Counter()  );
        new RebuildBSTFromPreOrder().inorder(node);
        System.out.println();
        new RebuildBSTFromPreOrder().preorder(node);
    }

    private Node buildNTime(int[] preOrder, int lower, int upper,Counter c) {
        if(c.c==preOrder.length) return null;

        int rootValue = preOrder[c.c];
        if(rootValue<lower || rootValue>upper){
            return null;
        }
        c.c++;
        Node node = new Node(rootValue);
        node.left = buildNTime(preOrder,lower,rootValue,c);
        node.right = buildNTime(preOrder,rootValue,upper,c);
        return node;
    }


    private Node build(int[] preOrder, int s, int e) {
        if (s >= e) {
            return null;
        }
        int transitionPoint = s + 1;
        while (transitionPoint < preOrder.length && preOrder[transitionPoint] < preOrder[s]) {
            transitionPoint++;
        }
        Node node = new Node(preOrder[s]);
        node.left = build(preOrder, s + 1, transitionPoint);
        node.right = build(preOrder, transitionPoint, e);
        return node;
    }


    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        preorder(node.left);
        preorder(node.right);
    }
}
