package com.shulga.co;

/**
 * Created by ievgen on 10/6/2014.
 */
public class WeightedQuickUnionUF {
    private int[] num;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        this.count = N;
        num = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int i) {
        while (i != num[i]) {
            i = num[i];
        }
        return i;
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        int p = find(i);
        int m = find(j);
        if (p == m) {
            return;
        }
        if (sz[p] > sz[m]) {
            sz[p] += sz[m];
            num[m] = p;
        } else {
            sz[m] += sz[p];
            num[p] = m;
        }
        count--;
    }

    public int count() {
        return count;
    }
}
