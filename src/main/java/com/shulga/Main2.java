package com.shulga;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(new int[][]{{1, 0}, {0, 1}}, in, out);
        out.close();
    }

    static class TaskA {
        private static void processA(int ai, Map<Integer, Integer> map) {
            if (map.get(ai) == null) {
                map.put(ai, 1);
            } else {
                map.put(ai, map.get(ai) + 1);
            }
        }

        private static void processB(int bi, Map<Integer, Integer> map) {
            if (map.get(bi) == null) {
                map.put(bi, -1);
            } else {
                map.put(bi, map.get(bi) - 1);
            }
        }

        public void solve(int[][] arrr, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[] B = new int[m];
            for (int i = 0; i < m; i++) {
                B[i] = in.nextInt();
            }
            int smallerLength = A.length < B.length ? A.length : B.length;
            int biggerLength = A.length > B.length ? A.length : B.length;

            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < smallerLength; i++) {
                processA(A[i], map);
                processB(B[i], map);
            }
            if (biggerLength == B.length) {
                for (int i = smallerLength; i < biggerLength; i++) {
                    processB(B[i], map);
                }
            } else {
                for (int i = smallerLength; i < biggerLength; i++) {
                    processA(A[i], map);
                }
            }

            Set<Integer> set = new HashSet<>();
            for (Map.Entry<Integer, Integer> counter : map.entrySet()) {
                if (counter.getValue() != 0) {
                    set.add(counter.getKey());
                }
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for (Integer counter : list) {
                out.print(counter+" ");
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