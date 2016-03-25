package com.shulga.hr;


import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eugene on 3/15/16.
 */
public class SumOf50DigitNumber {
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
            String[] numbers = new String[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = in.next();
            }
            java.util.Stack<Integer> stack = new java.util.Stack<>();
            int reminder = 0;
            for (int i = 49; i >= 0; i--) {
                int sum = reminder;
                for (int j = 0; j < N; j++) {
                    sum += Integer.parseInt(String.valueOf(numbers[j].charAt(i)));
                }
                stack.push(sum % 10);
                reminder = sum / 10;
            }
            stack.push(reminder);
            for (int i = 0; i < 10; i++) {
                out.print(stack.pop());
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
