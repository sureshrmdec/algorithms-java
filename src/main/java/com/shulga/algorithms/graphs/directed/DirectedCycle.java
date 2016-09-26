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
            }

        }
        onStack[m] = false;
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
        Digraph g = new Digraph(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4, 5);
        g.addEdge(5, 1);
        DirectedCycle c = new DirectedCycle(g);
        if(c.hasCycle()){
            c.printCycle();
        }else{
            System.out.println("No cycle");
        }
    }

}
