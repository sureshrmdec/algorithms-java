package com.shulga.algorithms.graphs.model;

public class GraphHelper {
	public static int degree(Graph g, int v) {
		int count = 0;
		for (Integer vertex : g.adj(v)) {
			count++;
		}
		return count;
	}

	public static int maxDegree(Graph g) {
		int maxDegree = 0;
		for (int i = 0; i < g.V(); i++) {
			int localMax = degree(g, i);
			if (localMax > maxDegree) {
				maxDegree = localMax;
			}
		}
		return maxDegree;
	}

	public static double averageDegree(Graph g) {
		return 2.0 * g.E() / g.V();
	}

	public static int numbersOfSelfLoop(Graph g) {
		int count = 0;
		for (int i = 0; i < g.V(); i++) {
			for (Integer vertex : g.adj(i)) {
				if (vertex == i) {
					count++;
				}
			}
		}
		return count;
	}
}
