package com.shulga.hr;

import java.io.*;
import java.util.StringTokenizer;


public class SavePrisoner {
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
            int cases = in.nextInt();
            for (int i = 0; i < cases; i++) {
                int N = in.nextInt();
                int candies = in.nextInt();
                int pick = in.nextInt();
                if(N==1){
                    System.out.println(1);
                    continue;

                }
                int num = candies % N;
                int id;
                int sum = pick + num - 1;
                if (sum <= N) {
                    id = sum;
                } else {
                    id = sum % N;
                }
                System.out.println(id);
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
