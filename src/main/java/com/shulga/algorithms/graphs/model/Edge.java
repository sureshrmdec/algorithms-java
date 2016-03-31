package com.shulga.algorithms.graphs.model;

/**
 * Created by eugene on 3/30/16.
 */
public class Edge implements Comparable<Edge>{
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v,int w, int weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int ver) {
        if(ver==v) return w;
        else if(ver==w) return v;
        return -1;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.getWeight()<o.getWeight()){
            return -1;
        }else if(this.getWeight()>o.getWeight()){
            return 1;
        }
        return 0;
    }
}
