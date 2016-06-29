package com.shulga.algorithms.graphs.model;

import java.util.LinkedList;

/**
 * Created by eugene on 6/26/16.
 */
public class Digraph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;
    public Digraph(int v){
        this.V=v;
        this.E=0;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int n,int m){
        adj[n].add(m);
        E++;
    }

    public LinkedList<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph reverseGraph = new Digraph(V());
        for (int i = 0; i < V; i++) {
            for (Integer r : adj(i)){
                reverseGraph.addEdge(r,i);
            }
        }
        return reverseGraph;
    }
}
