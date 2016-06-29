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
        for(Integer child: g.adj(m)){
            if(!marked[child]){
                dfs(g,child);
            }
        }
    }

    public static void main(String[] args) {
        //TODO
    }
}
