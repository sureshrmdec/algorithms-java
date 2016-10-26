package com.shulga.algorithms.graphs.m;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 10/2/16.
 */
public class DetectCycle {
    static class GraphVertex {
        public GraphVertex(Color color) {
            this.color = color;
        }

        enum Color {WHITE, BLACK, GRAY}
        Color color;
        List<GraphVertex> edges = new ArrayList<>();
    }

    public static void main(String[] args) {
        GraphVertex g = new GraphVertex(GraphVertex.Color.WHITE);
        GraphVertex e = new GraphVertex(GraphVertex.Color.WHITE);
        GraphVertex cycle = new GraphVertex(GraphVertex.Color.WHITE);
        cycle.edges.add(g);
        e.edges.add(cycle);
        g.edges.add(e);
        System.out.println(new DetectCycle().hasCycle(g));
    }

    private boolean hasCycle(GraphVertex g) {
        if(g.color== GraphVertex.Color.GRAY) return true;

        g.color = GraphVertex.Color.GRAY;
        for (GraphVertex e:g.edges){
            if(e.color!= GraphVertex.Color.BLACK){
                boolean b = hasCycle(e);
                if (b) return true;
            }
        }
        g.color = GraphVertex.Color.BLACK;
        return false;
    }
}
