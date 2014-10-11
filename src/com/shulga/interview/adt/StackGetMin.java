package com.shulga.interview.adt;

/**
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time.
 * <p/>
 * Created by ievgen on 10/11/2014.
 */
public class StackGetMin {
    private int[] mins = new int[10];
    private int[] buffer = new int[10];
    private int bufferN;
    private int minN;

    public void push(int data) {
        buffer[bufferN++] = data;
        if (minN == 0 || data < mins[minN]) {
            mins[minN++] = data;
        }
    }

    public int pop() {
        int item = buffer[bufferN--];
        if (mins[minN] == item) {
            minN--;
        }
        return item;
    }

    public int min() {
        return mins[minN];
    }

}
