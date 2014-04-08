package com.shulga.algorithms.graphs.model;

import java.util.List;

public interface Graph {
	void addEdge(int v, int w);
	
	List<Integer> adj(int v);
	
	int V();
	
	int E();
}
