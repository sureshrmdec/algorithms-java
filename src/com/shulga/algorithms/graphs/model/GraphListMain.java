package com.shulga.algorithms.graphs.model;

public class GraphListMain {
	public static void main(String[] args) {
		Graph g = new GraphList(10);

		g.addEdge(0, 1); // AB
		g.addEdge(1, 2); // BC
		g.addEdge(0, 3); // AD
		g.addEdge(3, 4); // DE
		
		DepthFirstPath path = new DepthFirstPath(g, 2);
		System.out.println(path.hasPathTo(4));
		System.out.println(path.hasPathTo(5));
		System.out.println(path.pathTo(4).toString());
		
		
	}
	
	private static GraphMatrix getGraphForMST(){
		GraphMatrix g = new GraphMatrix();
		
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
	
}
