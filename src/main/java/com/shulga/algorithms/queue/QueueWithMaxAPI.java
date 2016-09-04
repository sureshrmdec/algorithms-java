package com.shulga.algorithms.queue;

import java.util.LinkedList;

/**
 * Created by eshulga on 8/22/16.
 */
public class QueueWithMaxAPI {
    private Node first;
    private Node last;
    private LinkedList<Integer> max = new LinkedList();

    public static void main(String[] args) {
        QueueWithMaxAPI q = new QueueWithMaxAPI();
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(2);
        q.pop();
        q.pop();
        q.enqueue(7);
        q.enqueue(6);
        q.enqueue(9);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }

    boolean isEmpty() {
        return first == null;
    }

    public void enqueue(int num) {
        boolean empty = isEmpty();
        if (empty) {
            first = new Node();
            first.data = num;
            last = first;
        } else {
            Node node = new Node();
            node.data = num;
            last.next = node;
            last = node;
        }
        if (empty || max.getLast() > num) {
            max.addLast(num);
        } else {
            while (!max.isEmpty() && max.getLast() < num) {
                max.removeLast();
            }
            max.addLast(num);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty queue");
        }
        int res = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        if(max.getFirst()==res){
            max.removeFirst();
        }
        return res;

    }

    public int peek() {
        if (!isEmpty()) {
            return first.data;
        }
        throw new IllegalArgumentException("Empty queue");
    }

    static class Node {
        int data;
        Node next;
    }

}
