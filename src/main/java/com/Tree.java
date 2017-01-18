package com;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by eshulga on 12/19/16.
 */
public class Tree {
    private Node list;


    public Tree(List[] arrays) {
        Node node = new Node(null);
        Node first = node;
        for (int i = 0; i < arrays.length; i++) {
            Iterator<Integer> cur = arrays[i].iterator();
            node.next = new Node(cur);
            node = node.next;
        }
        node.next = first.next;
        list = first.next;
    }

    public static void main(String[] args) {
        List[] ar = new List[3];
        ar[0] = Arrays.asList(1,  2, 3, 4);
        ar[1] = Arrays.asList(10, 11);
        ar[2] = Arrays.asList(100,111, 222, 333,555);
        Tree tree = new Tree(ar);
        while (tree.hasNext()) {
            System.out.println(tree.next());
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return list.val.hasNext();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        Integer next = list.val.next();
        if (!list.val.hasNext()) {
            Node tmp = list.next;
            list.val = tmp.val;
            list.next = list.next.next;
        }else {
            list = list.next;
        }
        return next;
    }

    public static class Node {
        Iterator<Integer> val;
        Node next;

        Node(Iterator<Integer> list) {
            val = list;
        }
    }
}
