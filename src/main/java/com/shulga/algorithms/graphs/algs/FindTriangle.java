package com.shulga.algorithms.graphs.algs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eshulga on 10/7/16.
 */
public class FindTriangle {
    public static void main(String[] args) {
        FindTriangle findTriangle = new FindTriangle();
        System.out.println(findTriangle.find(3, new int[]{}, new int[]{}));
        System.out.println(findTriangle.find(4, new int[]{0, 2, 1, 2}, new int[]{3, 0, 2, 3}));
        System.out.println(findTriangle.find(6, new int[]{0, 0, 2}, new int[]{3, 1, 4}));

        System.out.println(findTriangle.find2(3, new int[]{}, new int[]{}));
        System.out.println(findTriangle.find2(4, new int[]{0, 2, 1, 2}, new int[]{3, 0, 2, 3}));
        System.out.println(findTriangle.find2(6, new int[]{0, 0, 2}, new int[]{3, 1, 4}));
    }

    int find(int n, int[] x, int[] y) {
        boolean[][] m = new boolean[n][n];
        for (int i = 0; i < x.length; i++) {
            m[x[i]][y[i]] = true;
            m[y[i]][x[i]] = true;
        }
        int min = 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j]) {
                    min = Math.min(min, 2);
                    for (int k = 0; k < n; k++) {
                        if (m[j][k]) {
                            min = Math.min(min, 1);
                            if (m[k][i]) return 0;
                        }
                    }
                }
            }
        }
        return min;
    }

    int find2(int n, int[] x, int[] y) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < x.length; i++) {
            if(graph[x[i]]==null) graph[x[i]] = new ArrayList<>();
            if(graph[y[i]]==null) graph[y[i]] = new ArrayList<>();
            graph[x[i]].add(y[i]);
            graph[y[i]].add(x[i]);
        }
        int min = 3;
        for (int i = 0; i < n; i++) {
            if(graph[i]==null) continue;
            for (int j = 0; j < graph[i].size(); j++) {
                if(graph[j]==null) continue;
                int adj = graph[i].get(j);
                min = Math.min(min, 2);
                for (int k = 0; k <graph[adj].size(); k++) {
                    min = Math.min(min, 1);
                    if(graph[adj].get(k)==i) return 0;
                }
            }
        }
        return min;
    }
}
