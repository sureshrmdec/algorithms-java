package com.shulga;

import java.util.LinkedList;

/**
 * Created by eshulga on 2/24/16.
 */
public class WhetherBipartileGraph {
    private LinkedList<Integer>[] adj;
    private int V;

    WhetherBipartileGraph(int N) {
        V = N;
        adj = new LinkedList[V];
        for (int i = 0; i < N; i++) {
            adj[i] = new LinkedList();
        }
    }

    public static void main(String[] args) {
        WhetherBipartileGraph g1 = new WhetherBipartileGraph(7);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(5, 2);
        g1.addEdge(1, 6);
        g1.addEdge(6, 1);
//        g1.addEdge(6, 5);
        System.out.println(g1.bipartile());
    }

    public void addEdge(int i, int j) {
        adj[i].add(j);
        adj[j].add(i);
    }

    public int V() {
        return V;
    }

    boolean bipartile() {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[V];
        int[] color = new int[V];
        queue.push(0);
        color[0] = 1;
        while (!queue.isEmpty()) {
            Integer pop = queue.pop();
            for (Integer child : adj[pop]) {
                if (color[child] == 0) {
                    color[child] = flip(color[pop]);
                }else if(color[child]==color[pop]){
                    return false;
                }
                if(!marked[child]) {
                    marked[child] = true;
                    queue.push(child);
                }
            }
        }
        return true;
    }

    int flip(int i) {
        return i == 1 ? 2 : 1;
    }

}
