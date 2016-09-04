package com.shulga.algorithms.stack;

/**
 * Created by eugene on 2/13/16.
 */
public class SortStack {
    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<>();
        stack.push(10);
        stack.push(2);
        stack.push(30);
        stack.push(4);
        for (Integer num : stack) {
            System.out.print(num + " ");
        }
        sort(stack);
        System.out.println();
        for (Integer num : stack) {
            System.out.print(num + " ");
        }

    }

    public static void sort(StackLinkedList<Integer> stack) {
        if (stack.isEmpty()) return;
        Integer pop = stack.pop();
        sort(stack);
        sortedInsertEnd(stack, pop);
    }

    public static void sortedInsertEnd(StackLinkedList<Integer> stack, Integer num) {
        if (stack.isEmpty() || stack.peek()>num) {
            stack.push(num);
            return;
        }
        Integer value = stack.pop();
        sortedInsertEnd(stack, num);
        stack.push(value);
    }
}
