package com.shulga.algorithms.graphs.model;

public class Vertex {
	private char label;
	private boolean visited;

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
