package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;

import java.util.Stack;

/**
 * Created by eugene on 6/26/16.
 */
public class DirectedCycleBook {
    private boolean[] marked;        // marked[v] = has vertex v been marked?
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)

    public DirectedCycleBook(Digraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);

        // check that digraph has a cycle
        assert check(G);
    }


    // check that algorithm computes either the topological order or finds a directed cycle
    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) return;

                //found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }

        onStack[v] = false;
    }

    public boolean hasCycle()        { return cycle != null;   }
    public Iterable<Integer> cycle() { return cycle;           }


    // certify that digraph is either acyclic or has a directed cycle
    private boolean check(Digraph G) {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }


        return true;
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
        DirectedCycleBook finder = new DirectedCycleBook(g);
        if(finder.hasCycle()){
            System.out.println("Cycle: ");
            for (int v : finder.cycle()) {
                System.out.println(v + " ");
            }
        }else{
            System.out.println("No cycle");
        }
    }

}
