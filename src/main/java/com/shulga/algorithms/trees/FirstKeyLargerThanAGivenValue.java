package com.shulga.algorithms.trees;

/**
 * Created by eugene on 9/4/16.
 */
public class FirstKeyLargerThanAGivenValue {
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
        root.left.left.left = new Node(5, "5b");
        root.left.left.left.right = new Node(4, "4a");
        System.out.println(new FirstKeyLargerThanAGivenValue().runReq(root, 5).value);
    }

    private static Node runReq(Node node, int k) {
        Node current = node;
        Node candidate = node;
        while(current!=null){
            if(k<current.key){
                candidate = current;
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return candidate;
    }
}
