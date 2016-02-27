package com.shulga.algorithms.stack;
import java.io.*;
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        int[] parent;
        int[] size;
        int[] changeLogSmall;
        int[] changeLogBig;
        int changeLogPtr;
        int numOdd;


        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            out.print(n);
            int[][] ar = new int[n][n];
            for(int i=0;i<n;i++){
                for (int j = 0; j < n; j++) {
                    int value = in.nextInt();
                    ar[i][j] = value;
                }


            }
            int left = 0;
            int right = 0;
            for(int i=0,j=0;i<ar[0].length;i++,j++){
                left = left+ar[i][j];
            }
            int j=n-1;
            for(int i=0;i<ar[0].length;i++,j--){
                right = right+ar[i][j];

            }
            System.out.println(left);
            System.out.println(right);
            System.out.println(left-right);
            System.out.println();
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