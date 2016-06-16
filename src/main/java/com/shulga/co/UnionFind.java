package com.shulga.co;

public class UnionFind {
    private int[] ar;
    private int[] treeDepth;

    public UnionFind(int N) {
        ar = new int[N];
        for (int i = 0; i < N; i++) {
            ar[i] = i;
            treeDepth[i] = 0;
        }
    }

    public int find(int p) {
        while (p != ar[p]) {
            p = ar[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }
        if (treeDepth[pRoot] < treeDepth[qRoot]) {
            ar[pRoot] = qRoot;
        } else if (treeDepth[qRoot] < treeDepth[pRoot]) {
            ar[qRoot] = pRoot;
        } else {
            ar[qRoot] = pRoot;
            treeDepth[pRoot]++;
        }
    }

}
