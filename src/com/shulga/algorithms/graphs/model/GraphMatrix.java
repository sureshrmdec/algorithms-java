package com.shulga.algorithms.graphs.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ievgen
 * 
 */
public class GraphMatrix implements Graph {
	private final int MAX_VERTS = 30;
	private Vertex[] vertixList;
	private int[][] adjMatrix;
	private int nVerts;

	public GraphMatrix() {
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
		while (!stack.isEmpty()) {
			Integer currentVertex = stack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if (v == -1) {
				stack.pop();
			} else {
				stack.push(v);
				vertixList[v].setVisited(true);
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.println();
			}
		}
	}

	public void topologicalSort() {
		char[] sorted = new char[nVerts];
		int origVerts = nVerts;
		while (nVerts > 0) {
			int current = noSuccessors();
			if (current == -1) {
				System.out.println("ERROR: cycles exits in graph");
				return;
			}
			sorted[nVerts - 1] = vertixList[current].getLabel();
			deleteVertex(current);
		}
		System.out.println("Topological sort:");
		for (int i = 0; i < origVerts; i++) {
			System.out.print(sorted[i]);
		}
	}

	private void deleteVertex(int delVert) {
		// if not the last
		if (delVert != nVerts - 1) {
			for (int i = delVert; i < nVerts - 1; i++) {
				vertixList[i] = vertixList[i + 1];
			}

			for (int row = delVert; row < nVerts - 1; row++) {
				moveRowUp(row, nVerts);
			}

			for (int col = 0; col < nVerts - 1; col++) {
				moveColLeft(col, nVerts);
			}
		}
		nVerts--;
		
	}

	private void moveColLeft(int col, int length) {
		for (int row = 0; row < length; row++) {
			adjMatrix[row][col] = adjMatrix[row + 1][col];
		}
	}

	private void moveRowUp(int row, int length) {
		for (int col = 0; col < length; col++) {
			adjMatrix[row][col] = adjMatrix[row][col + 1];
		}
	}

	/**
	 * @return vertex that does not have successors or -1
	 */
	private int noSuccessors() {
		boolean isEdge;
		for (int row = 0; row < nVerts; row++) {
			isEdge = false;
			for (int col = 0; col < nVerts; col++) {
				if (adjMatrix[row][col] == 1) {
					isEdge = true;
					break;
				}
			}
			if (!isEdge) {
				return row;
			}
		}
		return -1;
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

	@Override
	public Iterator<Integer> adj(int v) {
		// TODO Auto-generated method stub
		return null;
	}
}
