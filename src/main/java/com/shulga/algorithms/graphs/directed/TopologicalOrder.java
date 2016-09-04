package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;

import java.util.Stack;

/**
 * Created by eugene on 6/26/16.
 */
public class TopologicalOrder {
    private Stack<Integer> topologicalSort ;
    static DFSOrder dfsOrder;

    public TopologicalOrder(Digraph g) {
        DirectedCycle cycle = new DirectedCycle(g);
        if (!cycle.hasCycle()) {
             dfsOrder = new DFSOrder(g);
            topologicalSort = dfsOrder.reversePost();
        }
    }

    Stack<Integer> getTopologicalSort(){
        return topologicalSort;
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
//        g.addEdge(5, 6);
        g.addEdge(3, 6);
        TopologicalOrder c = new TopologicalOrder(g);

        System.out.println();
        System.out.println("Reverse Post");
        Stack<Integer> reversePost = dfsOrder.reversePost();
        while (!reversePost.isEmpty()) {
            System.out.print(reversePost.pop() + " ");
        }
        System.out.println();
        System.out.println("Topological sort");
        Stack<Integer> topologicalSort = c.getTopologicalSort();
        while (!topologicalSort.isEmpty()){
            System.out.print(topologicalSort.pop()+" ");
        }
    }
}
