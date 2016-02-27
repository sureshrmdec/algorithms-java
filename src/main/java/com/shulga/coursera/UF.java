package com.shulga.coursera;

/**
 * Created by eshulga on 2/8/16.
 */
public class UF {
    private int[] tree;
    private int[] weights;

    UF(int n){
        tree = new int[n];
        weights = new int[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = i;
        }
    }

    public int root(int i){
        while(i!=tree[i]){
            i=tree[i];
        }
        return i;
    }

    public boolean connected(int i,int j){
        return root(tree[i])==root(tree[j]);
    }

    public void union(int i,int j){

    }

}
