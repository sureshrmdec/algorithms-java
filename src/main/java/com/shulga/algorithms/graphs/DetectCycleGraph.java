package com.shulga.algorithms.graphs;

import java.util.LinkedList;

/**
 * Created by eshulga on 2/23/16.
 */
public class DetectCycleGraph {
    private LinkedList<Integer>[] adj;
    private int V;

    DetectCycleGraph(int N) {
        V = N;
        adj = new LinkedList[V];
        for (int i = 0; i < N; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int i,int j){
        adj[i].add(j);
        adj[j].add(i);
    }

    public int V() {
        return V;
    }

    boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (Integer n : adj[v]) {
            if (!visited[n]) {
                isCyclicUtil(n, visited, v);
            } else if (n != parent) {
                return true;
            }
        }
        return false;
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < V(); i++) {
            if (!visited[i]) {
                boolean cyclicUtil = isCyclicUtil(i, visited, -1);
                if (cyclicUtil) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleGraph g1 = new DetectCycleGraph(10);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(5, 2);
        g1.addEdge(1, 6);
        g1.addEdge(6, 1);

//        g1.addEdge(4, 3);
//        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        DetectCycleGraph g2 = new DetectCycleGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 0);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }


}
