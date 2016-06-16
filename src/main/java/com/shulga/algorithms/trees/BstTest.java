package com.shulga.algorithms.trees;

/**
 * Created by eshulga on 6/1/16.
 */
public class BstTest<K extends Comparable, V> {
    private BstNode root;

    public int size(BstNode root) {
        return root.size;
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return size(root);
    }

    public void put(K key, V value) {
        put(key, value, root);
    }

    public BstNode put(K key, V value, BstNode node) {
        if (node == null) {
            return new BstNode(key, value, 1);
        }
        int comp = key.compareTo(node.key);
        if (comp == 0) {
            node.value = value;
        } else if (comp < 0) {
            node.left = put(key, value, node.left);
        } else {
            node.right = put(key, value, node.right);
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public V min() {
        return min(root);
    }

    private V min(BstNode node) {
        if (node.left == null) {
            return node.value;
        }
        return min(node.left);
    }

    class BstNode {
        BstNode left;
        BstNode right;
        K key;
        V value;
        Integer size;

        BstNode(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
}
