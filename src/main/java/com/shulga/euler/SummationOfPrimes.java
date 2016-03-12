package com.shulga.euler;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 3/11/16.
 */
public class SummationOfPrimes {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.primes(30);
//        solver.solve(new int[]{-4, -1, 2, 3, 4}, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int[] ars, InputReader in, PrintWriter out) {
            int cases = in.nextInt();
            for (int k = 0; k < cases; k++) {
                int num = in.nextInt();

            }
        }

        public int[] primes(int N){
            boolean[] primes = new boolean[N];
            for (int i = 0; i < primes.length; i++) {
                primes[i] = true;
            }
            for (int i = 2; i < N; i++) {
                if(primes[i]){
                    for (int j = i+i; j < N; j+=i) {
                        primes[j] = false;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if(primes[i]) {
                    System.out.print(i+" ");
                }
            }
            return new int[1];
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
