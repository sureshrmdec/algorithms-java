package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eugene on 6/26/16.
 */
public class DFSOrder {
    int[] pre;
    int[] post;
    Queue<Integer> postOrder = new LinkedList<>();
    Queue<Integer> preOrder = new LinkedList<>();
    int preCounter;
    int postCounter;
    private boolean[] marked;

    DFSOrder(Digraph g) {
        marked = new boolean[g.V()];
        pre = new int[g.V()];
        post = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 1);
        g.addEdge(3, 6);
        DFSOrder c = new DFSOrder(g);

        System.out.println();
        System.out.println("Pre");
        for (Integer i : c.preOrder) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Post");
        for (Integer i : c.postOrder) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Reverse Post");
        Stack<Integer> reversePost = c.reversePost();
        while(!reversePost.isEmpty()) {
            System.out.print(reversePost.pop() + " ");
        }

    }

    Stack<Integer> reversePost() {
        Stack<Integer> stack = new Stack<>();
        for(Integer i: postOrder){
            stack.push(i);
        }
        return stack;
    }

    private void dfs(Digraph g, int m) {
        marked[m] = true;
        pre[m] = preCounter++;
        preOrder.add(m);
        System.out.print(m + " .");
        for (Integer child : g.adj(m)) {
            if (!marked[child]) {
                dfs(g, child);
            }
        }
        post[m] = postCounter++;
        postOrder.add(m);
    }
}
