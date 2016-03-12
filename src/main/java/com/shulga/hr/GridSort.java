package com.shulga.hr;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by eugene on 3/6/16.
 */
public class GridSort {
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
                char[][] ar = new char[N][N];
                for (int j = 0; j < N; j++) {
                    String s = in.next();
                    for (int k = 0; k < N; k++) {
                        ar[j][k] = s.charAt(k);
                    }
                }
                for (int j = 0; j < N; j++) {
                    Arrays.sort(ar[j]);
                }
                boolean res = true;
                for (int j = 0; j < N; j++) {
                    for (int k = 1; k < N; k++) {
                        if (ar[k][j] < ar[k - 1][j]) {
                            res=false;
                            break;
                        }
                    }
                    if(!res){
                        break;
                    }
                }
                if(res) {
                    out.println("YES");
                }else{
                    out.println("NO");
                }
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
