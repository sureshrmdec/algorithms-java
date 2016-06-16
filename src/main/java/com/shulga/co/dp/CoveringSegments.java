package com.shulga.co.dp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by eshulga on 3/2/16.
 */
public class CoveringSegments {
    public static void main(String[] args) {
        int[] res = new CoveringSegments().run(new int[][]{{1, 3}, {2, 5}, {3, 6}});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        res = new CoveringSegments().run(new int[][]{{4, 7}, {1, 3}, {2, 5}, {5, 6}});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private int[] run2(int[][] ints) {

        return null;
    }
    private int[] run(int[][] ints) {
        List<int[]> list = new ArrayList<>();
        list.add(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            int[] current = ints[i];
            boolean hit = false;
            for (Iterator<int[]> it = list.iterator(); it.hasNext(); ) {
                int[] ar = it.next();
                //overlaps
                if (current[0] <= ar[1] && current[0] > ar[0]) {
                    ar[0] = current[0];
                    hit = true;
                }
                if (current[1] >= ar[0] && current[1] < ar[1]) {
                    ar[1] = current[1];
                    hit = true;
                }
                if (hit) {
                    break;
                }
            }
            if (!hit) {
                list.add(current);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int[] a : list) {
            res[i] = a[1];
            i++;
        }
        return res;
    }
}
