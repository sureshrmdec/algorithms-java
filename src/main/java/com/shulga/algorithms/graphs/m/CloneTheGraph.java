package com.shulga.algorithms.graphs.m;

import java.util.*;

/**
 * Created by eugene on 10/2/16.
 */
public class CloneTheGraph {
    static class MVertex{
        MVertex(int label){
            this.label=label;
        }
        int label;
        List<MVertex> edges = new ArrayList<>();
    }

    public static void main(String[] args) {

        new CloneTheGraph().run(new MVertex(1));
    }

    private void run(MVertex mVertex) {
        Map<MVertex,MVertex> map = new HashMap<>();
        Queue<MVertex> queue = new LinkedList<>();
        queue.add(mVertex);
        map.put(mVertex, new MVertex(mVertex.label));
        while(!queue.isEmpty()){
            MVertex poll = queue.poll();
            for (MVertex e:poll.edges){
                if(!map.containsKey(e)) {
                    queue.add(e);
                    map.put(e,new MVertex(e.label));
                }
                map.get(mVertex).edges.add(e);
            }
        }
        map.get(mVertex);
    }
}
