package com.shulga.algorithms.adt;

/**
 * How you could use a single array to implement three stacks.
 * Created by ievgen on 10/11/2014.
 */
public class ArrayThreeStacks {
    private int[] ar;
    private int size;
    private int[] pointers = {0, 0, 0};

    public ArrayThreeStacks(int eachStackSize) {
        this.size = eachStackSize;
        ar = new int[eachStackSize * 3];
    }

    public void push(int data, int stack) {
        int position = stack * size + pointers[stack];
        if (position == stack * size + size) {
            throw new IllegalArgumentException("Stack is full");
        }
        ar[position] = data;
        pointers[stack]++;
    }
}
