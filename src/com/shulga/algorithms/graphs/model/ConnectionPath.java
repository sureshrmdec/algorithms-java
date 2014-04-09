package com.shulga.algorithms.graphs.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ConnectionPath {
	private Graph graph;
	int count = 0;
	private boolean[] marked;
	private Integer[] ids;

	public ConnectionPath(Graph graph) {
		this.graph = graph;
		marked = new boolean[graph.V()];
		ids = new Integer[graph.V()];
		for (int i = 0; i < graph.V(); i++) {
			if (!marked[i]) {
				dfs(graph, i);
				count++;
			}
		}
	}

	public boolean isConnected(int v, int w) {
		return ids[v] == ids[w];
	}

	private void dfs(Graph graph, int first) {
		marked[first] = true;
		ids[first] = count;
		for (Integer item : graph.adj(first)) {
			if (!marked[item]) {
				dfs(graph, item);
			}
		}
	}
}
