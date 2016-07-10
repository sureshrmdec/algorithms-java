package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;

/**
 * Created by eugene on 6/26/16.
 */
public class TopologicalOrder {
    public TopologicalOrder(Digraph g) {
        DirectedCycle cycle = new DirectedCycle(g);
        if (!cycle.hasCycle()) {
            //TODO
            //reverseDFSPostorder
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
        TopologicalOrder c = new TopologicalOrder(g);

    }
}
