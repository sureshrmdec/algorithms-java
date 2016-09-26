package com.shulga.algorithms.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 9/4/16.
 */
public class FindKLargestElements {
    static class Node {
        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }

        Node left;
        Node right;
        int key;
        String value;
    }

    public static void main(String[] args) {
        Node root = new Node(20, "20a");
        root.left = new Node(10, "10a");
        root.right = new Node(50, "50a");
        root.left.left = new Node(5, "5a");
        root.left.right = new Node(13, "13a");
        root.left.left.left = new Node(3, "5b");
        root.left.left.left.right = new Node(4, "4a");
        List<Integer> topK = new ArrayList<>();
        new FindKLargestElements().run(root, 5, topK);
        for (Integer i : topK) {
            System.out.println(i + " ");
        }
    }

    private List<Integer> run(Node node, int k, List<Integer> topK) {
        if (node != null) {
            run(node.right, k, topK);
            if (topK.size() < k) {
                topK.add(node.key);
            }
            run(node.left, k, topK);
        }
        return null;
    }

}
