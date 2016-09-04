package com.shulga.algorithms.linkedlist;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 * <p>
 * Created by ievgen on 10/10/2014.
 */
public class LinkedListAdd {

    public static LinkedListNode add2(LinkedListNode<Integer> one, LinkedListNode<Integer> two, int left) {
        if (one == null && two == null) {
            return null;
        }
        LinkedListNode node = new LinkedListNode();
        int sum = 0;
        if (one != null) {
            sum += one.data;
        }
        if (two != null) {
            sum += two.data;
        }
        node.data = sum % 10;
        node.next = add2(one != null ? one.next : null, two != null ? two.next : null, sum >= 10 ? 1 : 0);
        return node;
    }


    public static LinkedListNode add(LinkedListNode<Integer> one, LinkedListNode<Integer> two, int left) {
        if (one == null && two == null) {
            return null;
        }
        LinkedListNode<Integer> carrier = new LinkedListNode();
        int result = left;
        if (one != null) {
            result += one.data;
        }
        if (two != null) {
            result += two.data;
        }
        left = result % 10;
        carrier.data = left;

        carrier.next = add(one != null ? one.next : null, two != null ? two.next : null, result >= 10 ? 1 : 0);
        return carrier;
    }

    public static void main(String[] args) {
        LinkedListNode one = new LinkedListNode();
        one.fill(9, 8, 1);
        LinkedListNode two = new LinkedListNode();
        two.fill(2, 1);
        LinkedListNode add = add(one, two, 0);
        add.print();
        LinkedListNode add2 = addNonRecursive(one, two);
        System.out.println();
        add2.print();
    }

    /**
     * Input: (3 -> 1 -> 5), (5 -> 9 -> 2) 513 + 295, 315 + 592
     * Output: 8 -> 0 -> 8
     */
    public static LinkedListNode addNonRecursive(LinkedListNode<Integer> one, LinkedListNode<Integer> two) {
        int reminder = 0;
        LinkedListNode resHead = null;
        LinkedListNode res = null;
        while (one != null || two != null) {
            int sum = 0;
            if (one != null && two != null) {
                sum = one.data + two.data + reminder;
                one = one.next;
                two = two.next;
            } else if (one == null) {
                sum = two.data + reminder;
                two = two.next;
            } else if (two == null) {
                sum = one.data + reminder;
                one = one.next;
            }
            if (sum >= 10) {
                reminder = 1;
            } else {
                reminder = 0;
            }

            if (res == null) {
                res = new LinkedListNode();
                res.data = sum % 10;
                resHead = res;
            } else {
                res.next = new LinkedListNode();
                res.next.data = sum % 10;
                res = res.next;
            }
        }
        if (reminder == 1) {
            res.next = new LinkedListNode();
            res.next.data = reminder;
        }
        return resHead;
    }

}
