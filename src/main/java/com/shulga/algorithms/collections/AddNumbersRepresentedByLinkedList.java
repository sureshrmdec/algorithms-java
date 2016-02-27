package com.shulga.algorithms.collections;

import java.util.LinkedList;

/**
 * Add two numbers represented by linked lists | Set 2
 * Given two numbers represented by two linked lists, write a function that returns sum list. The sum list is linked list representation of addition of two input numbers.
 * It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).
 * <p>
 * Example
 * <p>
 * Input:
 * First List: 5->6->3  // represents number 563
 * Second List: 8->4->2 //  represents number 842
 * Output
 * Resultant list: 1->4->0->5  // represents number 1405
 */
public class AddNumbersRepresentedByLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(5);
        l1.add(6);
        l1.add(3);
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(8);
        l1.add(4);
        l1.add(2);
        System.out.println(l1.peek());
        System.out.println(l1.peek());
        System.out.println(l1.peek());
        System.out.println(new AddNumbersRepresentedByLinkedList().run(l1,l2, new LinkedList<Integer>()));
    }

    private LinkedList<Integer> run(LinkedList<Integer> l1, LinkedList<Integer> l2,LinkedList<Integer> res) {
        return null;
    }
}
