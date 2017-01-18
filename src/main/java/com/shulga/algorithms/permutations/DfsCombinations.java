package com.shulga.algorithms.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eshulga on 10/11/16.
 * C(n,r)=n!/r!(n−r)!
 *
 * With repetition:
 * C(n+r−1,r)=(n+r−1)!/r!(n−1)! = (4+3-2)!/3!3! = 120/36 ; = 5!/3!3!=20/6
 */
public class DfsCombinations {
    public static void main(String[] args) {
//        List<List<Integer>> combinations = new DfsCombinations().combinations(3, 2);
//        for (List<Integer> l : combinations) {
//            System.out.println(l);
//        }
//        System.out.println();
        List<String> combinations = new DfsCombinations().combinations("1234", 3);
        System.out.println(combinations);
        System.out.println("Total: "+combinations.size());
    }

    private List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k > n) return res;
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list, res);
        return res;
    }

    private void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }

    }

    private List<String> combinations(String s, int k) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0 || k > s.length()) return res;
        dfs(s, k, 0, "", res);
        return res;
    }

    private void dfs(String s, int k, int start, String tmp, List<String> res) {
        if (tmp.length() == k) {
            res.add(new String(tmp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            tmp = tmp.concat((s.charAt(i) + ""));
            dfs(s, k, i + 1, tmp, res);
            tmp = tmp.substring(0, tmp.length() - 1);
        }

    }
}
