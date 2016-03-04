package com.shulga.euler;

import com.shulga.coursera.chapter4.HeapMaxPriority;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 3/1/16.
 */
public class LargestPalindomeProduct {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(new int[]{-4, -1, 2, 3, 4}, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int[] ars, InputReader in, PrintWriter out) {
            int cases = in.nextInt();
            for (int k = 0; k < cases; k++) {
                int num = in.nextInt();
                int palindrome = 0;
                for (int i = 999; i >= 100; i--) {
                    for (int j = 999; j >= 100; j--) {
                        int res = i * j;
                        if (isPalindrome(res) && res < num && res > palindrome) {
                            palindrome = res;
                        }
                    }
                }
                out.println(palindrome);
            }
        }

        private boolean isPalindrome(int res) {
            String num = String.valueOf(res);
            int i=0;
            int j = num.length()-1;
            while(i<j){
                if(num.charAt(i)!=num.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
