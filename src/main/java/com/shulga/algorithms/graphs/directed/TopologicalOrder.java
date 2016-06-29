package com.shulga.algorithms.graphs.directed;

import com.shulga.algorithms.graphs.model.Digraph;

/**
 * Created by eugene on 6/26/16.
 */
public class TopologicalOrder {
    public TopologicalOrder(Digraph g){
        DirectedCycle cycle = new DirectedCycle(g);
        if(!cycle.hasCycle()){
            //TODO
            //reverseDFSPostorder
        }
    }
}
