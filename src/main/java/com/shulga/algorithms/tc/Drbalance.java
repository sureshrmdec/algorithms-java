package com.shulga.algorithms.tc;

/**
 * Created by eshulga on 10/12/15.
 */
public class Drbalance {
    public int lesscng(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;
        while(computePrefs(chars) > k) {
            ++ans;
            for(int i = 0; i < n; i++) {
                if(chars[i] == '-') {
                    chars[i] = '+';
                    break;
                }
            }
        }
        return ans;
    }

    public int computePrefs(char[] chars) {
        int bal = 0;
        int cnt = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '+') {
                bal++;
            } else {
                bal--;
            }
            if(bal < 0) {
                ++cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Drbalance().lesscng("-------++",3));
    }
}
