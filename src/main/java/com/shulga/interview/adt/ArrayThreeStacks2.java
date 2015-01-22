package com.shulga.interview.adt;

/**
 * Created by ievgen on 10/11/2014.
 */
public class ArrayThreeStacks2 {
    private Node[] ar;
    private int indexUsed = 0;
    private int[] pointers = {-1, -1, -1};

    public ArrayThreeStacks2(int size) {
        ar = new Node[size * 3];
    }

    public void push(int data, int stackNum) {
        int lastIndex = pointers[stackNum];
        pointers[stackNum] = indexUsed;
        indexUsed++;
        ar[pointers[stackNum]] = new Node(data, lastIndex);
    }

    public int pop(int stack) {
        Node node = ar[pointers[stack]];
        indexUsed--;
        ar[pointers[stack]] = null;
        pointers[stack] = node.lastIndex;
        return node.data;
    }

    private class Node {
        private int data;
        private int lastIndex;

        public Node(int data, int lastIndex) {
            this.data = data;
            this.lastIndex = lastIndex;
        }
    }
}
