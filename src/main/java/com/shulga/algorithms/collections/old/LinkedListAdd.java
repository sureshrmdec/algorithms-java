package com.shulga.algorithms.collections.old;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 * <p>
 * Created by ievgen on 10/10/2014.
 */
public class LinkedListAdd {

    public static LinkedListNode add(LinkedListNode<Integer> one, LinkedListNode<Integer> two, int left) {
        if (one == null && two == null) {
            return null;
        }
        LinkedListNode carrier = new LinkedListNode();
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
        LinkedListNode add2 = add2(one, two, 0);
        add.print();
        System.out.println();
        add2.print();
    }

    public static LinkedListNode add2(LinkedListNode<Integer> one, LinkedListNode<Integer> two, int reminder) {
        if (one == null && two == null) {
            return null;
        }
        LinkedListNode resultNumber = new LinkedListNode();
        int res = reminder;
        if (one != null) {
            res += one.data;
        }
        if (two != null) {
            res += two.data;
        }
        resultNumber.data = res % 10;
        resultNumber.next = add2(one != null ? one.next : null, two != null ? two.next : null, res >= 10 ? 1 : 0);
        return resultNumber;
    }
}
