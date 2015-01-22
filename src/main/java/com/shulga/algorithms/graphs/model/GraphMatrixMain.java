package com.shulga.algorithms.graphs.model;

public class GraphMatrixMain {
    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix();
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

        System.out.println("Minimum spanning tree in Weighted graph:");
        g = new GraphMatrix();
        addVertixes(g);
        g.addVertex('F');

        g.addEdge(0, 1, 6);
        g.addEdge(0, 3, 4);
        g.addEdge(1, 2, 10);
        g.addEdge(1, 3, 7);
        g.addEdge(1, 4, 7);
        g.addEdge(2, 3, 8);
        g.addEdge(2, 4, 5);
        g.addEdge(2, 5, 6);
        g.addEdge(3, 4, 12);
        g.addEdge(4, 5, 7);
        g.minimumSpanningTree();
    }

    private static GraphMatrix getGraphForMST() {
        GraphMatrix g = new GraphMatrix();
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

    public static void addVertixes(GraphMatrix g) {
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
    }
}
