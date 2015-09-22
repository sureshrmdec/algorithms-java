package com.shulga.algorithms.tc;

/**
 * Created by eshulga on 9/22/15.
 */
public class PointDistance {

    int[] findPoint(int x1, int y1, int x2, int y2) {
        int p[] = {(x2 > x1) ? x2 + 1 : x2 - 1, y2};
        return p;
    }
}
