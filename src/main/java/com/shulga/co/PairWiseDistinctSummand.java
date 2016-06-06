package com.shulga.co;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eshulga on 3/2/16.
 */
public class PairWiseDistinctSummand {
    public static void main(String[] args) {
        for (Integer s : new PairWiseDistinctSummand().run(10)) {
            System.out.print(s + " ");
        }
        System.out.println();
        int sum = 0;
        for (int i = 1; i <= 15; i++) {
            sum+=i;
            System.out.print(sum + " ");
        }
    }

    private List<Integer> run(int num) {
        List<Integer> list = new ArrayList<>();
        int current = 0;
        for (int i = 1; i <= num; i++) {
            current += i;
            if (current + i + 1 <= num) {
                list.add(i);
            } else {
                list.add(num - (current-i));
                break;
            }
            if (current == num) {
                break;
            }
        }
        return list;
    }
}
