package com.shulga.algorithms.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 6/15/16.
 * <p>
 * 1.append - Append string  to the end of .
 * 2.delete - Delete the last  characters of .
 * 3.print - Print the  character of .
 * 4.undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
 * 8
 * 1 abc
 * 3 3
 * 2 3
 * 1 xy
 * 3 2
 * 4
 * 4
 * 3 1
 */
public class SimpleTextEditor {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(new int[]{1, 1, 3}, in, out);
        out.close();
    }


    static class TaskA {

        public void solve(int[] arr, InputReader in, PrintWriter out) {
            Stack<String> stack = new Stack<>();
            int m = in.nextInt();
            stack.push("");
            for (int i = 0; i < m; i++) {
                int op = in.nextInt();
                if (op == 1) {
                    stack.push(stack.peek() + in.next());
                } else if (op == 2) {
                    stack.push(stack.peek().substring(0, stack.peek().length() - in.nextInt()));
                }
                if (op == 3) {
                    out.println(stack.peek().charAt(in.nextInt()-1));
                } else if (op == 4){
                    stack.pop();
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
