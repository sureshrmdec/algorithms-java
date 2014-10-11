package com.shulga.interview.adt;

import com.shulga.algorithms.collections.adt.Stack;
import com.shulga.algorithms.collections.adt.StackArray;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * <p/>
 * Created by ievgen on 10/11/2014.
 */
public class TwoStacksQueue {
    private Stack<Integer> s1 = new StackArray<Integer>();
    private Stack<Integer> s2 = new StackArray<Integer>();

    public void push(int data) {
        s1.push(data);
    }

    public Integer pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    public Integer peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.peek());
        }
        return s2.peek();
    }

//    public int size(){
//        return s1.size() +s2.size();
//    }

}
