package com.shulga.algorithms.tree.bst.model;

/**
 * Created by eugene on 10/18/15.
 */
public class BST<K extends Comparable,V> {
    private BSTNode root;

    private class BSTNode{
        BSTNode(K key,V value,int size){
            this.key = key;
            this.value=value;
            this.size=size;
        }
        BSTNode left;
        BSTNode right;
        K key;
        V value;
        int size;
    }

    public int size(){
        return size(root);
    }

    private int size(BSTNode  node){
        if(node==null){
            return 0;
        }
        return node.size;
    }

    public void put(K key, V value){
        root = putReq(key,value,root);
    }
    private BSTNode putReq(K key,V value,BSTNode node){
        if(node==null){
            return new BSTNode(key,value,1);
        }
        int res = key.compareTo(node.key);
        if(res==0){
            node.value=value;
        }else if(res<0){
            node.left= putReq(key, value, node.left);
        }else{
            node.right = putReq(key, value, node.right);
        }
        node.size = size(node.left)+size(node.right);
        return node;
    }

    public static void main(String[] args) {
        BST<Integer,Integer> bst = new BST<Integer,Integer>();
        bst.put(5,500);
        bst.put(4,400);
//        bst.put(4,400);
        bst.put(3,300);
        bst.put(1,100);
        bst.put(0,0);
        bst.put(-3,-300);
        bst.put(-1,-100);

//        System.out.println(bst.find(4));
//        System.out.println(bst.find(5));
        System.out.println(bst.floor(-2));
    }

    public V min(){
        BSTNode node = minReq(root);
        if(node==null){
            return null;
        }
        return node.value;
    }

    private BSTNode minReq(BSTNode node){
        if(node.left==null) return node;
        return minReq(node.left);
    }

    public V floor(K key){
        BSTNode res = floorReq(key,root);
        if(res==null){
            return null;
        }
        return res.value;
    }

    public K select(int k){
        return selectReq(root,k).key;
    }

    private BSTNode selectReq(BSTNode node,int k){
        if(node==null) return null;
        int t = size(node.left);
        if(t>k){
            return selectReq(node.left,k);
        }else if(t<k){
            return selectReq(node.right,k-t-1);
        }else{
            return node;
        }
    }

    public int rank(K key){
        return rankReq(key,root);
    }

    private int rankReq(K key,BSTNode node){
        if(node==null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp<0){
            return rankReq(key,node.left);
        }else if(cmp>0){
            return size(node.left)+1+rankReq(key,node.right);
        }else{
            return size(node.left);
        }
    }

    private BSTNode floorReq(K key,BSTNode node){
        if(node==null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp==0){
            return node;
        }
        if(cmp<0){
            return floorReq(key,node.left);
        }
        BSTNode t = floorReq(key,node.right);
        if(t!=null){
            return t;
        }else{
            return node;
        }
    }

    public V find(K key){
        return findReq(key,root);
    }

    private V findReq(K key,BSTNode node){
        if(node==null){
            return null;
        }
        int res = key.compareTo(node.key);
        if(res==0){
            return node.value;
        }else if(res<0){
            return findReq(key, node.left);
        }else{
            return findReq(key, node.right);
        }
    }

    public boolean delete(K key,BSTNode node){
        BSTNode current = node;
        while(current!=null) {
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
