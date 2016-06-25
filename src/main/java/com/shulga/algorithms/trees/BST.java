package com.shulga.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eugene on 10/18/15.
 */
public class BST<K extends Comparable, V> {
    BSTNode root;

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
//        bst.put(5, 500);
//        bst.put(4, 400);
////        bst.put(4,400);
//        bst.put(3, 300);
//        bst.put(1, 100);
//        bst.put(0, 0);
//        bst.put(-3, -300);
//        bst.put(10, 1000);
//        bst.put(20, 2000);
//        bst.put(7, 700);

        bst.put(10, 100);
        bst.put(5, 50);
        bst.put(15, 1500);
//        bst.put(3, 300);
//        bst.put(4, 400);
//        bst.put(1, 100);

//        bst.dfs(bst.root);
//        System.out.println(bst.isFull(bst.root));
//        System.out.println(bst.rankNonReq(7, bst.root));
        bst.inorder(bst.root);
//        System.out.println(bst.rank(7));
    }

    public void inorderKthNode(BSTNode node, int k) {
        if (node == null) return;
        if (node.size > k) {
            inorder(node.left);
        } else if (node.size < k) {
            inorder(node.right);
        } else {
            System.out.println(node.value);
        }

    }

    void inorder(BSTNode tree) {
        LinkedList<Integer> queue = new LinkedList<>();
        Stack<BSTNode> stack = new Stack<>();
        BSTNode current = tree;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        while (!stack.isEmpty()) {
            BSTNode pop = stack.pop();

            Integer value = (Integer) pop.value;
            queue.add(value);
            System.out.println(value);

            if (pop.right != null) {
                pop = pop.right;
                while (pop != null) {
                    stack.push(pop);
                    pop = pop.left;
                }
            }
        }

    }

    boolean ifTreeIsSubtree(BSTNode tree, BSTNode subtree) {
        if (tree == null || subtree == null) return false;
        if (isIdentical(tree, subtree)) return true;
        return ifTreeIsSubtree(tree.left, subtree) || ifTreeIsSubtree(tree.right, subtree);
    }

    boolean isIdentical(BSTNode tree, BSTNode subtree) {
        if (tree == null && subtree == null) {
            return true;
        }
        if (tree == null || subtree == null) {
            return false;
        }
        return isIdentical(tree.left, subtree.left) && isIdentical(tree.right, subtree.right);
    }

    boolean isFull(BSTNode node) {
        if (node == null) return true;
        if ((node.left != null && node.right == null) || (node.right != null && node.left == null)) {
            return false;
        }
        return isFull(node.left) && isFull(node.right);
    }

    int minHight(BSTNode node) {
        if (node == null || node.left == null || node.right == null) {
            return 0;
        }
        return 1 + Math.min(height(node.left), height(node.right));
    }

    int height(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    void bfs(BSTNode node) {
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BSTNode pop = queue.poll();
            System.out.println(pop.key);
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }
        }
    }

    private void dfs(BSTNode node) {
        Stack<BSTNode> s = new Stack();
        s.push(node);
        while (!s.isEmpty()) {
            BSTNode pop = s.pop();
            System.out.println(pop.key);
            if (pop.right != null) {
                s.push(node.right);
            }
            if (pop.left != null) {
                s.push(node.left);
            }
        }
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

    private int nodeHight(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return node.hight;
    }

    public void put(K key, V value) {
        root = putReq(key, value, root, 0);
    }

    private BSTNode putReq(K key, V value, BSTNode node, int compareNum) {
        if (node == null) {
            return new BSTNode(key, value, 1, 1, compareNum);
        }
        int res = key.compareTo(node.key);
        if (res == 0) {
            node.value = value;
        } else if (res < 0) {
            node.left = putReq(key, value, node.left, ++compareNum);
        } else {
            node.right = putReq(key, value, node.right, ++compareNum);
        }
        node.size = 1 + size(node.left) + size(node.right);
        node.hight = 1 + Math.max(nodeHight(node.left), nodeHight(node.right));
        return node;
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

    private BSTNode minNonReq(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public V floor(K key) {
        BSTNode res = floorReq(key, root);
        if (res == null) {
            return null;
        }
        return res.value;
    }

    public V ceiling(K key) {
        BSTNode res = ceilingReq(key, root);
        if (res == null) {
            return null;
        }
        return res.value;
    }

    private BSTNode ceilingReq(K key, BSTNode node) {
        if (node == null) return null;
        int comp = key.compareTo(node.key);
        if (comp == 0) return node;
        if (comp > 0) {
            ceilingReq(key, node.right);
        }
        BSTNode res = ceilingReq(key, node.left);
        if (res == null) {
            return node;
        } else {
            return res;
        }
    }


    private BSTNode floorNonReq(K key, BSTNode node) {
        if (node == null) return null;
        BSTNode current = node;
        while (current.left != null && key.compareTo(current.left.key) < 0) {
            current = current.left;
        }
        return null;
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

    public K select(int k) {
        return selectReq(root, k).key;
    }

    private BSTNode selectReq(BSTNode node, int k) {
        if (node == null) return null;
        int t = size(node.left);
        if (t > k) {
            return selectReq(node.left, k);
        } else if (t < k) {
            return selectReq(node.right, k - t - 1);
        } else {
            return node;
        }
    }

    public void delete(K key) {
        root = deleteReq(key, root);
    }


    private BSTNode deleteMax(BSTNode node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private BSTNode deleteReq(K key, BSTNode node) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return deleteReq(key, node.left);
        } else if (cmp > 0) {
            return deleteReq(key, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            BSTNode temp = node;
            node = minReq(node.right);
            node.right = deleteMin(node.right);
            node.left = temp.left;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private BSTNode deleteMin(BSTNode node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    public int rank(K key) {
        return rankReq(key, root);
    }

    private int rankNonReq(K key, BSTNode node) {
        if (node == null) return 0;
        BSTNode current = node;
        int sum = 0;
        while (0 != key.compareTo(current.key)) {
            int comp = key.compareTo(current.key);
            if (comp < 0) {
                current = current.left;
            } else if (comp > 0) {
                sum += 1 + size(current.left);
                current = current.right;
            }
        }
        return sum + size(current.left);
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

    public Iterable<K> keys(K lo, K hi) {
        Queue<K> queue = new LinkedList<>();
        keysReq(root, queue, lo, hi);
        return queue;
    }


    private void keysReq2(BSTNode x, Queue<K> queue, K lo, K hi) {
        if (x == null) return;
        int loLimit = lo.compareTo(x.key);
        int hiLimit = hi.compareTo(x.key);
        if (loLimit < 0) {
            keysReq2(x.left, queue, lo, hi);
        }
        if (loLimit <= 0 && hiLimit >= 0) {
            queue.add(x.key);
        }
        if (hiLimit > 0) {
            keysReq2(x.right, queue, lo, hi);
        }

    }


    private void keysReq(BSTNode x, Queue<K> queue, K lo, K hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keysReq(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
        if (cmphi > 0) keysReq(x.right, queue, lo, hi);
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

    private class BSTNode {
        BSTNode left;
        BSTNode right;
        K key;
        V value;
        int size;
        int hight;
        int pathSize;

        BSTNode(K key, V value, int size, int hight, int pathSize) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.hight = hight;
            this.pathSize = pathSize;
        }
    }

}
