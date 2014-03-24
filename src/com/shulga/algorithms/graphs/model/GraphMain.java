package com.shulga.algorithms.graphs.model;

public class GraphMain {
	public static void main(String[] args) {
		Graph g = new Graph();
		addVertixes(g);

		g.addEdge(0, 1); // AB
		g.addEdge(1, 2); // BC
		g.addEdge(0, 3); // AD
		g.addEdge(3, 4); // DE
		
		System.out.println("Depth first search:");
		g.dfs(); //ABCDE
		
		System.out.println();
		System.out.println("Bredth first search:");
		g.bfs(); //ABDCE
		
		System.out.println();
		System.out.println("Minimum spanning tree:");
		g = getGraphForMST();
		g.mst();
	}
	
	private static Graph getGraphForMST(){
		Graph g = new Graph();
		addVertixes(g);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		return g;
	}
	
	public static void addVertixes(Graph g){
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
	}
}