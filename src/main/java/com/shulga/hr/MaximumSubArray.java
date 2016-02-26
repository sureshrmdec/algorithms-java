package com.shulga.hr;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 2/25/16.
 */
public class MaximumSubArray {
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
            int m = in.nextInt();
            for (int k = 0; k < m; k++) {
                int n = in.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextInt();
                }
            int maxSoFar = ar[0];
            int max = ar[0];
            int maxAllPositives = 0;
            if (ar[0] > 0) {
                maxAllPositives = ar[0];
            }
            for (int i = 1; i < ar.length; i++) {
                maxSoFar = maxSoFar + ar[i];
                if (maxSoFar <= 0) {
                    maxSoFar = Math.max(ar[i], maxSoFar);
                }

                max = Math.max(max, maxSoFar);
                if (ar[i] > 0) {
                    maxAllPositives += ar[i];
                }
            }
            if (maxAllPositives == 0) {
                maxAllPositives = max;
            }
            out.println(max + " " + maxAllPositives);
            }
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
