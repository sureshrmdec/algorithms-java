package com.shulga.algorithms.graphs;

import com.shulga.algorithms.graphs.model.Edge;
import com.shulga.algorithms.graphs.model.EdgeWeightedGraph;
import com.shulga.co.chapter4.HeapMinPriorityQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eshulga on 3/31/16.
 */
public class PrimMST {

    public List<Edge> eagerPrimMST(EdgeWeightedGraph g) {
        Edge[] edgeTo = new Edge[g.V()];
        double[] distTo = new double[g.V()];
        boolean[] marked = new boolean[g.V()];
        HeapMinPriorityQueue indexMinPQ = new HeapMinPriorityQueue(g.V()+1);
        for (int i = 0; i < g.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        return null;
    }

    public List<Edge> lazyPrimMST(EdgeWeightedGraph g) {
        boolean[] marked = new boolean[g.V()];
        HeapMinPriorityQueue minPQ = new HeapMinPriorityQueue(g.E() + 1);
        List<Edge> mst = new ArrayList<>();
        visitLazy(g, marked, 0, minPQ);
        while (!minPQ.isEmpty()) {
            Edge e = (Edge) minPQ.delMin();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.add(e);
            if (!marked[v]) {
                visitLazy(g, marked, v, minPQ);
            }
            if (!marked[w]) {
                visitLazy(g, marked, w, minPQ);
            }
        }
        return mst;
    }

    private void visitLazy(EdgeWeightedGraph g, boolean[] marked, int v, HeapMinPriorityQueue minPQ) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) {
                minPQ.insert(e);
            }
        }
    }

    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph(5);
        g.addEdge(new Edge(0, 1, 10));
        g.addEdge(new Edge(0, 2, 6));
        g.addEdge(new Edge(0, 3, 5));
        g.addEdge(new Edge(1, 3, 15));
        g.addEdge(new Edge(2, 3, 4));
        List<Edge> mst = new PrimMST().lazyPrimMST(g);
        for (Edge e : mst) {
            System.out.println(e.either() + "-" + e.other(e.either()) + "==" + e.getWeight());
        }
    }
}
