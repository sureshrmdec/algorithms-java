package com.shulga.tc.srm;

import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class FarmvilleDiv2 {
    static class Pair{
        Pair(int cost,int time){
            this.cost=cost;
            this.time=time;
        }
        int cost;
        int time;
    }

    public int minTime(int[] time, int[] cost, int budget) {
        int totalTime = 0;
        Pair[] pairs = new Pair[time.length];
        for (int i = 0; i < time.length; i++) {
            pairs[i] = new Pair(cost[i],time[i]);
            totalTime+=time[i];
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.cost-o2.cost;
            }
        });
        for (int i = 0; i < pairs.length; i++) {
            int amount = Math.min(budget/pairs[i].cost,pairs[i].time);
            totalTime-=amount;
            budget-=amount*pairs[i].cost;
        }

        return totalTime;
    }
}
