package com.shulga.hr;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 2/25/16.
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
            int change = in.nextInt();
            int[] ar = new int[N];
            for (int i = 0; i < N; i++) {
                ar[i] = in.nextInt();
            }
            for (int i = 0; i < change; i++) {
                int max = i;
                int j;
                for (j = i + 1; j < ar.length; j++) {
                    if (ar[j] > ar[max]) {
                        max = j;
                    }
                }
                swap(ar,i,max);
            }
            for (int i = 0; i < ar.length; i++) {
                out.print(ar[i] + " ");
            }
        }

        private void swap(int[] ar, int i, int j) {
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
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
