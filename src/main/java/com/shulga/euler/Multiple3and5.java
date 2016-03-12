package com.shulga.euler;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Multiple3and5 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(100, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int numm, InputReader in, PrintWriter out) {
            int cases = in.nextInt();
            for (int k = 0; k < cases; k++) {
                int num = in.nextInt();
                int max3 = num % 3 == 0 ? num - 3 : (num / 3) * 3;
                int max5 = num % 5 == 0 ? num - 5 : (num / 5) * 5;
                int max15 = num % 15 == 0 ? num - 15 : (num / 15) * 15;

                int sum3 = (3 + max3) * max3 / 6;
                int sum5 = (5 + max5) * max5 / 10;
                int sum15 = (15 + max15) * max15 / 30;
                out.println(sum3 + sum5 - sum15);
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