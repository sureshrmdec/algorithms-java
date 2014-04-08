package com.shulga.algorithms.graphs.model;

import java.util.Iterator;

public interface Graph {
	void addEdge(int v, int w);
	
	Iterator<Integer> adj(int v);
}
