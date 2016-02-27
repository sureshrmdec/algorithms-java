package com.shulga.algorithms.graphs;

import com.shulga.algorithms.graphs.model.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPath {
    private Graph graph;
    private int source;
    private boolean[] marked;
    private Integer[] edgeTo;

    public BreadthFirstPath(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        marked = new boolean[graph.V()];
        edgeTo = new Integer[graph.V()];
        bfs(graph, source);
    }

    public boolean hasPathTo(int dest) {
        return edgeTo[dest] != null;
    }

    public List<Integer> pathTo(int dest) {
        if (!hasPathTo(dest)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = dest; x != source; x = edgeTo[x]) {
            path.add(x);
        }
        path.add(source);
        return path;
    }

    private void bfs(Graph graph, int source) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            int vert = queue.poll();
            for (Integer item : graph.adj(vert)) {
                if (!marked[item]) {
                    queue.add(item);
                    marked[item] = true;
                    edgeTo[item] = vert;
                }
            }
        }
    }
}
