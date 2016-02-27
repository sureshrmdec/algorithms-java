package com.shulga.algorithms.collections.old.adt;

public interface Stack<T> {

    void push(T data);

    T pop();

    T peek();

    boolean isEmpty();
}
