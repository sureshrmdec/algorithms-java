package com.shulga.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eshulga on 9/26/16.
 */
public class IntervalCoveringProblem {
    static class Interval {
        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int left;
        int right;
    }
    public static void main(String[] args) {
        //(1,5),(2,0),(2,4),(2,3),(3,4),(4,5)
        System.out.println(new IntervalCoveringProblem().run(new Interval[]{new Interval(1,2),new Interval(2,3),new Interval(3,4),
        new Interval(3,4),new Interval(4,5)}));
    }

    //find min sized set of numbers that cover all intervals
    private List<Integer> run(Interval[] intervals) {
        Interval current = intervals[0];
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            Interval interv = intervals[i];
            if(interv.left<=current.right){
                current.right = Math.min(current.right,interv.right);
                current.left = Math.max(current.left,interv.left);
                if(i==intervals.length-1){
                    res.add(current.right);
                }
                continue;
            }
            res.add(current.right);
            current = interv;
        }
        return res;
    }
}
