package com.shulga.algorithms.stack;

public interface Stack<T> {

    void push(T data);

    T pop();

    T peek();

    boolean isEmpty();
}
