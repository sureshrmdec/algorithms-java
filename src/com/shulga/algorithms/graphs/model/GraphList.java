package com.shulga.algorithms.graphs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphList implements Graph {
	private int V;
	private List<Integer>[] adjList;
	
	public GraphList(int vertixCount){
		V = vertixCount;
		adjList = new ArrayList[vertixCount];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adjList[v].add(w);
		adjList[w].add(v);
	}
	
	public Iterator<Integer> adj(int v){
		return adjList[v].iterator();
	}
}
