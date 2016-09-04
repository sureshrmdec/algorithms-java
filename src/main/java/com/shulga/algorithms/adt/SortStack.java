package com.shulga.algorithms.adt;

import com.shulga.algorithms.stack.Stack;
import com.shulga.algorithms.stack.StackArray;

/**
 * Write a program to sort a stack in ascending order. You should not make any assumptions about how the stack is implemented.
 * The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
 * <p>
 * Created by ievgen on 10/11/2014.
 */
public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new StackArray<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(30);
        stack.push(2);
        Stack<Integer> stack1 = new SortStack().sort2(stack);
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop() + " ");
        }
    }

    public Stack<Integer> sort2(Stack<Integer> stack) {
        Stack<Integer> sorted = new StackArray<>();
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() < temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        return sorted;
    }

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
