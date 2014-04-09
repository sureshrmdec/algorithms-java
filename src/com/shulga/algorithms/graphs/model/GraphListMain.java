package com.shulga.algorithms.graphs.model;

public class GraphListMain {
	public static void main(String[] args) {
		Graph g = new GraphList(10);

		g.addEdge(0, 1); // AB
		g.addEdge(1, 2); // BC
		g.addEdge(0, 3); // AD
		g.addEdge(3, 4); // DE
		//separate
		g.addEdge(5, 6);
		
		DepthFirstPath depthPath = new DepthFirstPath(g, 2);
		System.out.println(depthPath.hasPathTo(4));
		System.out.println(depthPath.hasPathTo(5));
		System.out.println(depthPath.pathTo(4).toString());
		
		BreadthFirstPath breadthPath = new BreadthFirstPath(g, 0);
		System.out.println(breadthPath.pathTo(4).toString());
		
		ConnectionPath conPath = new ConnectionPath(g);
		System.out.println(conPath.isConnected(1, 4));
		System.out.println(conPath.isConnected(1, 5));
		System.out.println(conPath.isConnected(6, 5));
		
		
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
