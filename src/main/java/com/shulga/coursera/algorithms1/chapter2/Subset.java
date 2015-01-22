package com.shulga.coursera.algorithms1.chapter2;

/**
 * Created by ievgen on 10/7/2014.
 */
public class Subset {

    public static void main(String[] args) {
        int N = Integer.valueOf(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < N; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
