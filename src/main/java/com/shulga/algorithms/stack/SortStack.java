package com.shulga.algorithms.stack;

import com.shulga.coursera.chapter2.ArrayStack;

/**
 * Created by eugene on 2/13/16.
 */
public class SortStack {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(10);
        stack.push(2);
        stack.push(30);
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

    public static void insertEnd(ArrayStack<Integer> stack,Integer num) {
        if (stack.isEmpty() ) {//TODO
            stack.push(num);
            return;
        }
        Integer value = stack.pop();
            insertEnd(stack, num);
        stack.push(value);
    }
}
