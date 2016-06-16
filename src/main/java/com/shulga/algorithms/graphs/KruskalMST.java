package com.shulga.algorithms.graphs;

import com.shulga.algorithms.graphs.model.Edge;
import com.shulga.algorithms.graphs.model.EdgeWeightedGraph;
import com.shulga.co.WeightedQuickUnionUF;
import com.shulga.co.chapter4.HeapMinPriorityQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 3/30/16.
 */
public class KruskalMST {

    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph(5);
        g.addEdge(new Edge(0, 1, 10));
        g.addEdge(new Edge(0, 2, 6));
        g.addEdge(new Edge(0, 3, 5));
        g.addEdge(new Edge(1, 3, 15));
        g.addEdge(new Edge(2, 3, 4));
        List<Edge> mst = new KruskalMST().mstKruskal(g);
        for (Edge e : mst) {
            System.out.println(e.either() + "-" + e.other(e.either()) + "==" + e.getWeight());
        }
    }

    public List<Edge> mstKruskal(EdgeWeightedGraph g) {
        HeapMinPriorityQueue minPQ = new HeapMinPriorityQueue(g.E()+1);
        for (Edge e :g.edges()){
            minPQ.insert(e);
        }
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(g.edges().size());
        List<Edge> mst = new ArrayList<>();
        while(!minPQ.isEmpty() && mst.size()<g.V()-1) {
            Edge e = (Edge) minPQ.delMin();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.add(e);
        }
        return mst;
    }
}
