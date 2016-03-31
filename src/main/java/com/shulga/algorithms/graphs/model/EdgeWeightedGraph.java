package com.shulga.algorithms.graphs.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 3/30/16.
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private ArrayList<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        E = 0;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public List<Edge> edges() {
        List<Edge> list = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                if (e.other(v) > v) list.add(e);
            }
        }
        return list;
    }

    public void addEdge(Edge e) {
        int either = e.either();
        adj[either].add(e);
        adj[e.other(either)].add(e);
        E++;
    }

    public List<Edge> adj(int v) {
        return adj[v];
    }
}
