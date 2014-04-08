package com.shulga.algorithms.graphs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphList implements Graph {
	private int V;
	private int E;
	private List<Integer>[] adjList;

	public GraphList(int vertixCount) {
		V = vertixCount;
		adjList = new ArrayList[vertixCount];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
	}

	@Override
	public void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v);
		E++;
	}

	@Override
	public List adj(int v) {
		return adjList[v];
	}

	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}
}
