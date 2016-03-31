package com.shulga.algorithms.graphs;

import com.shulga.algorithms.graphs.model.Edge;
import com.shulga.algorithms.graphs.model.EdgeWeightedGraph;
import com.shulga.coursera.UF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by eugene on 3/30/16.
 */
public class KruskalMST {

    public List<Edge> mst(EdgeWeightedGraph g){
        List<Edge> edges = new ArrayList<>(g.edges());
        Collections.sort(edges);
        UF uf = new UF(edges.size());
        List<Edge> mst = new ArrayList<>();
        for (Edge e:edges){
            if(mst.size()==g.V()-1){
                break;
            }
            int v = e.either();
            int w = e.other(v);
            if(uf.connected(v,w)) continue;
            uf.union(v,w);
            mst.add(e);
        }
        return mst;
    }
}
