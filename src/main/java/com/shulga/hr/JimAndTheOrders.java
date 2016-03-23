package com.shulga.hr;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by eugene on 3/6/16.
 * TODO fails:
 * 3
 * 1 2
 * 2 1
 * 3 0
 */
public class JimAndTheOrders {
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
            int[] time = new int[N];
            int[] duration = new int[N];
            int[] sum = new int[N];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                time[i] = in.nextInt();
                duration[i] = in.nextInt();
                sum[i] = time[i] + duration[i];
                map.put(sum[i], i + 1);
            }
            Arrays.sort(sum);
            for (int i = 0; i < N; i++) {
                out.print(map.get(sum[i]) + " ");
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
