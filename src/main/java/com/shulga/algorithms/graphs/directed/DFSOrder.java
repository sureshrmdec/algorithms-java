package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;
import com.shulga.algorithms.stack.StackArray;

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
        Digraph g = new Digraph(13);
        g.addEdge(2, 3);
        g.addEdge(0, 6);
        g.addEdge(0, 1);
        g.addEdge(2, 0);
        g.addEdge(11,12);
        g.addEdge(9, 12);
        g.addEdge(9, 10);
        g.addEdge(9, 11);
        g.addEdge(3, 5);
        g.addEdge(8, 7);
        g.addEdge(5, 4);
        g.addEdge(0, 5);
        g.addEdge(6, 4);
        g.addEdge(6, 9);
        g.addEdge(7, 6);
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
        Stack<Integer> reversePost = (Stack<Integer>) c.reversePost();
        while(!reversePost.isEmpty()) {
            System.out.print(reversePost.pop() + " ");
        }

        System.out.println();
        System.out.println("Reverse Post ==2==");
        Iterable<Integer> reversePost2 = c.reversePost();
        for(Integer i : reversePost2) {
            System.out.print(i + " ");
        }

    }

    Iterable<Integer> reversePost() {
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
