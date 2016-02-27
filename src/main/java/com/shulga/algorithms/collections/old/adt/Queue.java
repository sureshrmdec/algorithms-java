package com.shulga.algorithms.collections.old.adt;

public interface Queue<T> {

    boolean isEmpty();

    void enqueue(T data);

    T dequeue();
}
