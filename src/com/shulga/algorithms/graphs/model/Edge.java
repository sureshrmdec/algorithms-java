package com.shulga.algorithms.graphs.model;

public class Edge {
    private int srcVert;
    private int destVert;
    private int distance;

    public Edge(int srcVert, int destVert, int distance) {
        super();
        this.srcVert = srcVert;
        this.destVert = destVert;
        this.distance = distance;
    }

    public int getSrcVert() {
        return srcVert;
    }

    public void setSrcVert(int srcVert) {
        this.srcVert = srcVert;
    }

    public int getDestVert() {
        return destVert;
    }

    public void setDestVert(int destVert) {
        this.destVert = destVert;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
