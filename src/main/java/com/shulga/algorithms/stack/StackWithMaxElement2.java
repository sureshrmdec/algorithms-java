package com.shulga.algorithms.stack;

import java.util.Stack;

/**
 * Created by eshulga on 8/22/16.
 */
public class StackWithMaxElement2 {
    private Stack<Max> stack = new Stack<>();
    private int[] ar;
    private int N = -1;
    StackWithMaxElement2(int N) {
        ar = new int[N];
    }

    public int pop() {
        int res = ar[N--];
        ar[N + 1] = 0;
        if (stack.peek().count > 1) {
            stack.peek().count--;
        } else {
            stack.pop();
        }
        return res;
    }

    public int peek() {
        return ar[N];
    }

    public void push(int num) {
        if (N >= ar.length - 1) {
            throw new IllegalArgumentException("stack is full");
        }
        if (N==-1 || num > peek()) {
            stack.push(new Max(num, 1));
        } else {
            stack.peek().count++;
        }
        ar[++N] = num;
    }

    static class Max {
        int max;
        int count;
        Max(int max, int count) {
            this.max = max;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        StackWithMaxElement2 s = new StackWithMaxElement2(10);
        s.push(5);
        s.push(4);
        s.push(2);
        s.push(6);
        s.push(1);
        s.push(7);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }

}
