package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;

import java.util.Stack;

/**
 * Created by eugene on 6/26/16.
 */
public class DirectedCycle {
    boolean[] marked;
    boolean[] onStack;
    int[] edgeTo;

    Stack<Integer> cycle = new Stack<>();
    DirectedCycle(Digraph g){
        marked = new boolean[g.V()];
        onStack = new boolean[g.V()];
        edgeTo = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }

    private void dfs(Digraph g,int m) {
        marked[m] = true;
        onStack[m] = true;
        for(Integer child: g.adj(m)){
            if(hasCycle()){
                return;
            }else if (!marked[child]){
                edgeTo[child] = m;
                dfs(g,child);
            }else if(onStack[child]){
                for (int i = m; i != child; i = edgeTo[i]) {
                    cycle.push(i);
                }
                cycle.push(child);
                cycle.push(m);
            }

        }
    }

    void printCycle(){
        while(!cycle.isEmpty()){
            System.out.println(cycle.pop());
        }
    }

    boolean hasCycle(){
        return !cycle.isEmpty();
    }


    public static void main(String[] args) {
        //TODO
    }

}
