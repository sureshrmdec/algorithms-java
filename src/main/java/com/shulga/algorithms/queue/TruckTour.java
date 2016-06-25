package com.shulga.algorithms.queue;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by eshulga on 6/16/16.
 * Suppose there is a circle. There are  petrol pumps on that circle. Petrol pumps are numbered  to  (both inclusive).
 * You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular
 * petrol pump will give, and (2) the distance from that petrol pump to the next petrol pump.

 Initially, you have a tank of infinite capacity carrying no petrol. You can start the tour at any of the petrol pumps.
 Calculate the first point from where the truck will be able to complete the circle. Consider that the truck will stop at
 each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.
 3
 1 5
 10 3
 3 4
 */
public class TruckTour {
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
