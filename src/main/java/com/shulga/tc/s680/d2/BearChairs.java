package com.shulga.tc.s680.d2;

import java.util.ArrayList;
import java.util.Collections;

public class BearChairs {

    public int[] findPositions(int[] atLeast, int d) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] res = new int[atLeast.length];
        list.add(Integer.MAX_VALUE);
        for (int i = 0; i < atLeast.length; i++) {
            int ans=0;
            if (atLeast[i] <= list.get(0) - d) {
                ans= atLeast[i];
            } else {
                for (int j = 0; j < list.size(); j++) {
                    ans = Math.max(atLeast[i], list.get(j)+d);
                    if (ans <= list.get(j+1) - d) {
                        break;
                    }
                }
            }
            res[i] =ans;
            list.add(ans);
            Collections.sort(list);

        }
        return res;
    }
}
