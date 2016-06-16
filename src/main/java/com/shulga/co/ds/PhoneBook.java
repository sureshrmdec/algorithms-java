package com.shulga.co.ds;

import java.util.LinkedList;

/**
 * Created by eugene on 6/15/16.
 */
public class PhoneBook {
    class Node{
        Node next;
        Integer key;
        String value;
    }
    Node[] hashMap = new Node[1000];

    public String find(Integer number){
        Node node = findNode(number);
        return node==null?null:node.value;
    }

    private Node findNode(Integer number){
        int hash = hashCode(number);
        Node node = hashMap[hash];
        while(node!=null){
            if(node.key.equals(number)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public boolean contains(Integer key){
        return find(key)!=null;
    }

    public void insert(Integer number,String name){
        Node find = findNode(number);
        if(find!=null){
            find.value=name;
            return;
        }
        int hash = hashCode(number);
        Node node = hashMap[hash];
    }


    public int hashCode(int num){
        return (31*num+2) % 10000019 % 1000;

    }
}
