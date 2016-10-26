package com.shulga.algorithms.graphs.matrix;

/**
 * Created by eshulga on 9/26/16.
 */
public class DijkstraSPT {
    public static void main(String[] args) {
         /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dijkstra(graph,0);
    }

    private static void dijkstra(int[][] graph, int s) {
        int[] dist = new int[graph.length];
        boolean[] sptSet = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[s] = 0;
        for (int i = 0; i < graph.length; i++) {
            int min = minDistance(sptSet,dist);
            sptSet[min] = true;
            for (int j = 0; j < graph[min].length; j++) {
                if(!sptSet[j] && graph[min][j]!=0 && dist[min]!=Integer.MAX_VALUE &&
                        dist[min]+graph[min][j]<dist[j]){
                    dist[j] = dist[min]+graph[min][j];
                }
            }
        }
        // print the constructed distance array
        printSolution(dist, graph.length);
    }

    private static int minDistance(boolean[] sptSet, int[] dist) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if(sptSet[i]==false && dist[i]<minDist){
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }
}
