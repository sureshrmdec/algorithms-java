package com.shulga.algorithms.graphs.model;

import java.util.List;
import java.util.Stack;

public class DepthFirstPath {
	private Graph graph;
	private int source;
	private boolean[] marked;
	private Integer[] edgeTo;

	public DepthFirstPath(Graph graph, int source) {
		this.graph = graph;
		this.source = source;
		marked = new boolean[graph.V()];
		edgeTo = new Integer[graph.V()];
		dfs(graph, source);
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

	private void dfs(Graph graph, int source) {
		marked[source] = true;
		for (Integer vertex : graph.adj(source)) {
			if (!marked[vertex]) {
				dfs(graph, vertex);
				edgeTo[vertex] = source;
			}
		}
	}
}
