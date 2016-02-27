package com.shulga.algorithms.adt;

import com.shulga.algorithms.collections.old.adt.Stack;
import com.shulga.algorithms.collections.old.adt.StackArray;

/**
 * Write a program to sort a stack in ascending order. You should not make any assumptions about how the stack is implemented.
 * The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
 * <p>
 * Created by ievgen on 10/11/2014.
 */
public class SortStack {

    public Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> sorted = new StackArray();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        return sorted;
    }
}
