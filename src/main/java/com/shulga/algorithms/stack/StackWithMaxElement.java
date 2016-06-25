package com.shulga.algorithms.stack;

/**
 * Created by eshulga on 6/23/16.
 */
public class StackWithMaxElement {
    private Pair[] ar;
    private int counter = -1;

    StackWithMaxElement() {
        ar = new Pair[20];
    }

    public static void main(String[] args) {
        StackWithMaxElement s = new StackWithMaxElement();
        s.push(1);
        s.push(12);
        s.push(3);
        System.out.println(s.max());
        System.out.println(s.pop());
        System.out.println(s.max());
        System.out.println(s.pop());
        System.out.println(s.max());
        System.out.println(s.pop());
        s.push(5);
        System.out.println(s.pop());
    }

    public void push(int n) {
        int max = n;
        if (counter > 0 && peek() > n) {
            max = peek();
        }
        ar[++counter] = new Pair(n, max);
    }

    public boolean isEmpty() {
        return counter == -1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("emptystack,cant peek");
        }
        return ar[counter].data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("emptystack,cant pop");
        }
        Pair data = ar[counter--];
        return data.data;
    }

    public int max() {
        if (isEmpty()) {
            throw new IllegalArgumentException("emptystack,cant peek");
        }
        return ar[counter].max;
    }

    private class Pair {
        int data;
        int max;

        Pair(int data, int max) {
            this.data = data;
            this.max = max;
        }

    }
}
