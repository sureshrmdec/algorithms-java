package com.shulga.algorithms.stack;

import com.shulga.co.chapter2.ArrayStack;

/**
 Reverse a stack using recursion
 You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
 isEmpty(S)
 push(S)
 pop(S)
 */
public class ReverseStack {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for (Integer num:stack){
            System.out.print(num+" ");
        }
        run(stack);
        for (Integer num:stack){
            System.out.print(num+" ");
        }

    }

    public static void run(ArrayStack<Integer> stack){
        if(stack.isEmpty()) return;
        Integer pop = stack.pop();
        run(stack);
        insertEnd(stack, pop);
    }

    public static void insertEnd(ArrayStack<Integer> stack,Integer num){
        if(stack.isEmpty()) {
            stack.push(num);
            return;
        }
        Integer value = stack.pop();
        insertEnd(stack,num);
        stack.push(value);
    }
}
