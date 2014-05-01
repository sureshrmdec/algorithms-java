package com.shulga.algorithms.graphs.model;

public class Vertex {
	private char label;
	private boolean visited;
	public boolean isInTree;
	
	public boolean isInTree() {
		return isInTree;
	}

	public void setInTree(boolean isInTree) {
		this.isInTree = isInTree;
	}

	public Vertex(char label) {
		this.label = label;
	}

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
