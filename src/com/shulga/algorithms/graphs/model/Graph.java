package com.shulga.algorithms.graphs.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private final int MAX_VERTS = 30;
	private Vertex[] vertixList;
	private int[][] adjMatrix;
	private int nVerts;

	public Graph() {
		vertixList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
	}

	public void addVertex(char label) {
		vertixList[nVerts++] = new Vertex(label);
	}

	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	// depth first search
	public void dfs() {
		Stack<Integer> stack = new Stack<Integer>();
		vertixList[0].setVisited(true);
		stack.push(0);
		displayVertex(0);
		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(stack.peek());
			if (v == -1) {
				stack.pop();
			} else {
				displayVertex(v);
				stack.push(v);
				vertixList[v].setVisited(true);
			}
		}
		for (int i = 0; i < nVerts; i++) {
			vertixList[i].setVisited(false);
		}
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		displayVertex(0);
		vertixList[0].setVisited(true);
		int v2;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			while ((v2 = getAdjUnvisitedVertex(v)) != -1) {
				queue.add(v2);
				displayVertex(v2);
				vertixList[v2].setVisited(true);
			}
		}
	}

	// minimum spanning tree (based on depth first search)
	public void mst() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		vertixList[0].setVisited(true);
		while(!stack.isEmpty()){
			Integer currentVertex = stack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v==-1){
				stack.pop();
			}else{
				stack.push(v);
				vertixList[v].setVisited(true);
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.println();
			}
		}
	}
	
	// return unvisited vertex adjacent to v
	public int getAdjUnvisitedVertex(int v) {
		for (int i = 0; i < MAX_VERTS; i++) {
			if (adjMatrix[v][i] == 1 && vertixList[i].isVisited() == false) {
				return i;
			}
		}
		return -1;
	}

	public void displayVertex(int vertex) {
		System.out.print(vertixList[vertex].getLabel() + ", ");
	}
}
