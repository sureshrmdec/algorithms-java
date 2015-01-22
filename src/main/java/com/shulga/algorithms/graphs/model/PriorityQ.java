package com.shulga.algorithms.graphs.model;

public class PriorityQ {
    private final int SIZE = 30;
    private Edge[] queueArray;
    private int size;

    public PriorityQ() {
        queueArray = new Edge[SIZE];
        size = 0;
    }

    public void insert(Edge item) {
        int i;
        for (i = 0; i < size; i++) {
            if (item.getDistance() >= queueArray[i].getDistance()) {
                break;
            }
        }
        for (int j = size - 1; j >= i; j--) {
            queueArray[j + 1] = queueArray[j];
        }
        queueArray[i] = item;
        size++;
    }

    public Edge removeMin() {
        return queueArray[--size];
    }

    public void removeN(int n) {
        for (int i = n; i < size - 1; i++) {
            queueArray[i] = queueArray[i + 1];
        }
        size--;
    }

    public Edge peekMin() {
        return queueArray[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Edge peekN(int n) {
        return queueArray[n];
    }

    public int find(int findDex) {
        for (int i = 0; i < size; i++) {
            if (queueArray[i].getDestVert() == findDex) {
                return i;
            }
        }
        return -1;
    }


}
