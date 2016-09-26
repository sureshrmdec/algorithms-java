package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eugene on 6/26/16.
 */
public class DepthFirstOrderBook {
    private boolean[] marked;          // marked[v] = has v been marked in dfs?
    private int[] pre;                 // pre[v]    = preorder  number of v
    private int[] post;                // post[v]   = postorder number of v
    private Queue<Integer> preorder;   // vertices in preorder
    private Queue<Integer> postorder;  // vertices in postorder
    private int preCounter;            // counter or preorder numbering
    private int postCounter;           // counter for postorder numbering

    // depth-first search preorder and postorder in a digraph
    public DepthFirstOrderBook(Digraph G) {
        pre    = new int[G.V()];
        post   = new int[G.V()];
        postorder = new LinkedList<>();
        preorder  = new LinkedList<>();
        marked    = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    // run DFS in digraph G from vertex v and compute preorder/postorder
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.add(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.add(v);
        post[v] = postCounter++;
    }


    public int pre(int v) {
        return pre[v];
    }

    public int post(int v) {
        return post[v];
    }

    // return vertices in postorder as an Iterable
    public Iterable<Integer> post() {
        return postorder;
    }

    // return vertices in postorder as an Iterable
    public Iterable<Integer> pre() {
        return preorder;
    }

    // return vertices in reverse postorder as an Iterable
    public Stack<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder)
            reverse.push(v);
        return reverse;
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


        DepthFirstOrderBook dfs = new DepthFirstOrderBook(g);
        System.out.println("   v  pre post");
        System.out.println("--------------");
        for (int v = 0; v < g.V(); v++) {
            System.out.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
        }

        System.out.print("Preorder:  ");
        for (int v : dfs.pre()) {
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.print("Postorder: ");
        for (int v : dfs.post()) {
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.print("Reverse postorder: ");
        Stack<Integer> stack = dfs.reversePost();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();


    }

}
