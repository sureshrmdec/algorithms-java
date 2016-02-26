package com.shulga;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by eshulga on 2/24/16.
 */
public class GraphPath {
    private LinkedList<Integer>[] adj;
    private int V;

    GraphPath(int N) {
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

    public Stack<Integer> findPath(int from, int to){
        boolean[] marked = new boolean[V];
        int[] edgeTo = new int[V];
        dfsReq(from, to, marked, edgeTo);
        Stack<Integer> path = new Stack<>();
        path.push(to);
        int next = to;
        while(edgeTo[next]!=from){
            path.push(edgeTo[next]);
            next = edgeTo[next];
        }
        path.push(from);
        return path;
    }

    private void dfsReq(int from, int to, boolean[] marked, int[] edgeTo) {
        marked[from] = true;
        for(Integer child: adj[from]){
            if(!marked[child]){
                edgeTo[child] = from;
                if(child==to){
                    return;
                }
                dfsReq(child,to,marked,edgeTo);
            }
        }
    }

    public int V() {
        return V;
    }

    public static void main(String[] args) {
        GraphPath g = new GraphPath(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(3,6);
        g.addEdge(1,6);
        for (Integer el : g.findPath(0,6)){
            System.out.print(el+" ");
        }
    }
}
