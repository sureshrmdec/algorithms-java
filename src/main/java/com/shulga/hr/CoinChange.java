package com.shulga.hr;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 2/25/16.
 * <p>
 * Example 1: For N=4 and C={1,2,3} there are four solutions:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}
 */
public class CoinChange {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(new int[]{2, 1, 3}, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int[] arr, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int num_coins = in.nextInt();
            int[] coins = new int[num_coins];
            for (int i = 0; i < num_coins; i++) {
                coins[i] = in.nextInt();
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
