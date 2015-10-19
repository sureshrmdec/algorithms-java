package com.shulga.algorithms.tc.div2practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by eshulga on 10/12/15.
 * <p>
 * <p>
 * <p>
 * {0, 1, 5, 6}
 * {1, 6, 0, 5}
 */
public class IsItASquare {

    private int euclid(int x0, int y0, int x1, int y1) {
        int dx = x0 - x1;
        int dy = y0 - y1;
        return dx * dx + dy * dy;
    }

    String isSquare(int[] x, int[] y) {
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (b != a) {
                    for (int c = 0; c < 4; c++) {
                        if (c != a && c != b) {
                            int d = 0;
                            while (d == a || d == b || d == a) {
                                d++;
                            }
                            int ab = euclid(x[a], y[a], x[b], y[b]);
                            int ac = euclid(x[a], y[a], x[c], y[c]);
                            int bd = euclid(x[b], y[b], x[d], y[d]);
                            int cd = euclid(x[c], y[c], x[d], y[d]);

                            int ad = euclid(x[a], y[a], x[d], y[d]);
                            int bc = euclid(x[b], y[b], x[c], y[c]);
                            if (ab == ac && ac == bd && bd == cd && ad == bc){
                                return "Its a square";
                            }
                        }
                    }
                }
            }
        }
        return "Not a square";
    }

    public String isSquare2(int[] x, int[] y) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int dx = x[i] - x[j];
                int dy = y[i] - y[j];
                list.add(dx * dx + dy * dy);
            }
        }
        Collections.sort(list);
        int l = list.get(0);
        if (l == 0) return "Not a square";
        if (list.get(0) == l && list.get(1) == l && list.get(2) == l && list.get(3) == l && list.get(4) == l * 2 && list.get(5) == l * 2) {
            return "It's a square";
        }
        return "Not a square";
    }


    public static void main(String[] args) {
        System.out.println(new IsItASquare().isSquare(new int[]{0, 0, 2, 2}, new int[]{0, 2, 0, 2}));
    }
}
