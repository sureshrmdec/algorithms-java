package com.shulga.coursera.chapter4;

/**
 * Created by eugene on 2/14/16.
 */
public class BST <Key extends Comparable,Value> {
    private class Node{
        Node left;
        Node right;
        Key key;
        Value value;
        int size;
        Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }
    private Node root;

    public static void main(String[] args) {
        BST bst = new BST<String,String>();
        bst.add("hello","4");
        bst.add("fyi","3");

    }

    public Value find(Key item){
        Node x = root;
        while(x!=null){
            if(x.key.compareTo(item)<0){
                x = x.left;
            }else if(x.key.compareTo(item)>0){
                x = x.right;
            }else{
                return x.value;
            }
        }
        return null;
    }

    private int size(Node node){
        if(node==null) return 0;
        return node.size;
    }

    private Node addInternal(Node node,Node newNode){
        if(node==null) return newNode;
        if(newNode.key.compareTo(node.key)<0){
            node.left = addInternal(node.left,newNode);
        }else if(newNode.key.compareTo(node.key)>0){
            node.right = addInternal(node.right,newNode);
        }else{
            node.value = newNode.value;
        }
        node.size = 1+size(node.left)+size(node.right);
        return node;
    }

    public void add(Key key,Value value){
        Node newNode = new Node(key,value);
        root = addInternal(root,newNode);
    }

    public int rank(Key key){
        return rankReq(key,root);
    }

    public int rankReq(Key key, Node root){
        if(root==null) return 0;
        int cmp = key.compareTo(root.key);
        if(cmp<0){
            return 1+rankReq(key,root.left);
        }else if(cmp>0){
            return 1+root.left.size+rankReq(key,root.right);
        }else{
            return root.size;
        }
    }

    public Value floor(Key key){
        return floor(key,root).value;
    }
    public Node floor(Key key,Node root){
        if(root==null) return null;
        int cmp = key.compareTo(root.key);

        if(cmp==0) return root;

        if(cmp<0){
            return floor(key, root.left);
        }

        Node t = floor(key,root.right);
        if(t != null){
            return t;
        }else{
            return root;
        }
    }
}
