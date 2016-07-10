package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;

/**
 * Created by eugene on 6/26/16.
 */
public class DirectedDFS {
    boolean[] marked;
    DirectedDFS(Digraph g,int m){
        marked = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if(!marked[i]){
                dfs(g,m);
            }
        }
    }

    private void dfs(Digraph g,int m) {
        marked[m] = true;
        System.out.println(m);
        for(Integer child: g.adj(m)){
            if(!marked[child]){
                dfs(g,child);
            }
        }
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(7);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4, 5);
        g.addEdge(5, 1);
        g.addEdge(3, 6);
        DirectedDFS c = new DirectedDFS(g,1);
    }
}
