package com.shulga.coursera.dp;

import java.util.Stack;

/**
 * Created by eugene on 3/12/16.
 * <p>
 * You are given a primitive calculator that can perform the following three operations with the current number
 * x: multiply x by 2, multiply x by 3, or add 1 to x. Your goal is given a positive integer n, find the
 * minimum number of operations needed to obtain the number n starting from the number 1.
 * Input:
 * 96234
 * Output:
 * 14
 * 1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
 */
public class PrimitiveCalculator {
    public static void main(String[] args) {
        Stack<Integer> stack = new PrimitiveCalculator().run(14);
        System.out.println(stack.size() - 1);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private Stack<Integer> run(int num) {
        int[] dp = new int[num + 1];
        for (int i = 2; i < num; i++) {
            int min = dp[i - 1];
            if (i % 2 == 0) {
                min = Math.min(dp[i / 2], min);
            }
            if (i % 3 == 0) {
                min = Math.min(dp[i / 3], min);
            }
            dp[i] = min + 1;
        }
        for (int i = 0; i < num; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        Stack<Integer> path = new Stack<>();
        int i = num;
        path.push(i);
        while (i > 0) {
            int min = dp[i - 1];
            int pointer = i - 1;
            if (i % 2 == 0 && dp[i / 2] < min) {
                min = dp[i / 2];
                pointer = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3] < min) {
                pointer = i / 3;
            }
            if (pointer == 0) {
                break;
            }
            path.push(pointer);
            i = pointer;
        }
        return path;

    }
}
