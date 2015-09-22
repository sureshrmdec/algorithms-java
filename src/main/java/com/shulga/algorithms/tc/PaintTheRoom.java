package com.shulga.algorithms.tc;

/**
 * Created by eshulga on 9/21/15.
 */
public class PaintTheRoom {

    String canPaintEvenly(int R, int C, int K) {
        if (K == 1 || R % 2 == 0 || C % 2 == 0) {
            return "Paint";
        }
        return "Not paint";
    }
}
