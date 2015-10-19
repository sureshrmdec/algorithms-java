package com.shulga.algorithms.tree.bst.model;

/**
 * Created by eugene on 10/18/15.
 */
public class BST<K extends Comparable, V> {
    private BSTNode root;

    private class BSTNode {
        BSTNode(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        BSTNode left;
        BSTNode right;
        K key;
        V value;
        int size;
    }

    public int size() {
        return size(root);
    }

    private int size(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public void put(K key, V value) {
        root = putReq(key, value, root);
    }

    private BSTNode putReq(K key, V value, BSTNode node) {
        if (node == null) {
            return new BSTNode(key, value, 1);
        }
        int res = key.compareTo(node.key);
        if (res == 0) {
            node.value = value;
        } else if (res < 0) {
            node.left = putReq(key, value, node.left);
        } else {
            node.right = putReq(key, value, node.right);
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public static void main(String[] args) {
        BST<Double, Integer> bst = new BST<Double, Integer>();
        bst.put(10.0, 1000);
        bst.put(5.0, 500);
        bst.put(6.0, 600);
        bst.put(7.0, 700);
        bst.put(8.0, 800);
        bst.put(11.0, 1100);
        bst.put(13.0, 1300);
        bst.put(12.0, 1200);
//        bst.put(0,0);
//        bst.put(-3,-300);
//        bst.put(-1,-100);

//        System.out.println(bst.find(4));
//        System.out.println(bst.find(5));
        System.out.println(bst.select(1));
        System.out.println(bst.rank(12.0));
    }

    public V min() {
        BSTNode node = minReq(root);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private BSTNode minReq(BSTNode node) {
        if (node.left == null) return node;
        return minReq(node.left);
    }

    public V floor(K key) {
        BSTNode res = floorReq(key, root);
        if (res == null) {
            return null;
        }
        return res.value;
    }

    public K select(int k) {
        return selectReq(root, k).key;
    }

    private BSTNode selectReq(BSTNode node, int target) {
        if (node == null) return null;
        int rootLeftSize = size(node.left);
        if (rootLeftSize > target) {
            return selectReq(node.left, target);
        } else if (rootLeftSize < target) {
            return selectReq(node.right, target - rootLeftSize - 1);
        } else {
            return node;
        }
    }

    public int rank(K key) {
        return rankReq(key, root);
    }

    private int rankReq(K key, BSTNode node) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rankReq(key, node.left);
        } else if (cmp > 0) {
            return size(node.left) + 1 + rankReq(key, node.right);
        } else {
            return size(node.left);
        }
    }

    public void deleteMin() {
        if (root == null) {
            throw new IllegalArgumentException("Empty tree");
        }
        root = deleteMinReq(root);
    }

    private BSTNode deleteMinReq(BSTNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMinReq(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void deleteMax() {
        if (root == null) {
            throw new IllegalArgumentException("Empty tree");
        }
        root = deleteMaxReq(root);
    }

    private BSTNode deleteMaxReq(BSTNode node) {
        if (node.right == null) {
            return node.left;
        }
        node = deleteMaxReq(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private BSTNode floorReq(K key, BSTNode node) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floorReq(key, node.left);
        }
        BSTNode t = floorReq(key, node.right);
        if (t != null) {
            return t;
        } else {
            return node;
        }
    }

    public V find(K key) {
        return findReq(key, root);
    }

    private V findReq(K key, BSTNode node) {
        if (node == null) {
            return null;
        }
        int res = key.compareTo(node.key);
        if (res == 0) {
            return node.value;
        } else if (res < 0) {
            return findReq(key, node.left);
        } else {
            return findReq(key, node.right);
        }
    }

    public boolean delete(K key, BSTNode node) {
        BSTNode current = node;
        while (current != null) {
            int res = key.compareTo(node.key);
            if (res == 0) {
                break;
            } else if (res < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

}
